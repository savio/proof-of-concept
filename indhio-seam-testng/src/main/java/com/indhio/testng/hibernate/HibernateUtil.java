package com.indhio.testng.hibernate;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;


/**
 * Classe utilit�ria para gerenciamento do Hibernate, tem como objetivos:
 * <ul>
 * <li>Inicializar uma �nica inst�ncia da SessionFactory do Hibernate;</li>
 * <li>Abrir Sessions do Hibernate;</li>
 * <li>Associar Sessions a ThreadsLocais;</li>
 * <li>Fechar Sessions associadas.</li>
 * </ul>
 * O pacote de anota��es para o Hibernate (Hibernate Annotations) requer uma classe
 * especial para a constru��o do SessionFactory. Por quest�es de compatibilidade com
 * aplica��es que j� utilizam a classe HibernateUtil, foi criado o m�todo setSessionFactory()
 * que recebe como par�metro um objeto da classe SessionFactory que substituir� o objeto criado
 * anteriormente dentro da classe. Desta maneira n�o alteramos a inicializa��o anterior da classe.
 * Utilize este m�todo caso o projeto utilize Hibernate Annotations.<br/><br/>
 * <i>Aten��o!</i> Uma exce��o pode ser disparada no momento em que HibernateUtil for carregada na mem�ria, 
 * caso o arquivo de configura��o do hibernate utilize a sintaxe permitida para o Hibernate Annotations. Se a
 * inten��o for utilizar annotations no projeto para efetuar o mapeamento das classes, ignore a exce��o e
 * utilize o m�todo setSessionFactory() para atribuir um factory v�lido para a aplica��o.
 */
public class HibernateUtil
{
    private static SessionFactory sessionFactory;
    private static Configuration configuration;
    private static boolean annotationActive = false;
    private static final ThreadLocal threadSession = new ThreadLocal();
    
    public static void initialize()
    {
        try
        {
            sessionFactory = configuration.configure().buildSessionFactory();
            System.out.println( ">> HIBERNATE INICIADO COM SUCESSO." );
        }
        catch ( Throwable e )
        {
        	System.out.println( ">> FALHA NA INICIA��O DO HIBERNATE." );
        	e.printStackTrace();
        }
    }

    public static Configuration getConfiguration() {
       	if( configuration == null )
       		configuration =  (annotationActive)? new AnnotationConfiguration(): new Configuration();
       	return configuration;
	}

	public static void setConfiguration(Configuration cfg) {
		HibernateUtil.configuration = cfg;
	}

	public static boolean isAnnotationActive() {
		return annotationActive;
	}

	public static void setAnnotationActive(boolean annotationActive) {
		HibernateUtil.annotationActive = annotationActive;
	}
	
	public static void reinitialize(){
		closeSession();
		initialize();
		getSession();
	}


	/**
     * Inicializa as propriedades de um objeto persistido.
     */
    public static void initializeProperties( Object obj )
    {
        if ( !Hibernate.isInitialized( obj ) )
        {
            Hibernate.initialize( obj );
        }
    }


    /**
     * Atualiza um objeto persistido.
     */
    public static void refreshObject( Object obj )
    {
        Session s = HibernateUtil.getSession();
        s.refresh( obj );
    }


    /**
     * Limpa a session corrente.
     */
    public static void clearSession()
    {
        Session s = HibernateUtil.getSession();
        s.clear();
    }


    /**
     * Retorna uma Session existente, ou ent�o abre uma nova e associa a ThreadLocal.
     * @return uma sess�o do Hibernate
     */
    public static Session getSession()
    {
    	if( sessionFactory == null ){
    		initialize();
    		closeSession();
    	}
    	
        Session s = (Session) threadSession.get();
        if ( s == null )
        {
            s = sessionFactory.openSession();
            threadSession.set( s );
        }
        return s;
    }


    /**
     * Fecha a Session associada a ThreadLocal.
     */
    public static void closeSession()
    {
        Session s = (Session) threadSession.get();
        threadSession.set( null );
        if ( s != null && s.isOpen() )
        {
            s.close();
        }
    }

    /**
     * Retorna uma Connection JDBC independente. <br> OBS: � necess�rio chamar o m�todo <tt>close()</tt> da conex�o a fim de fecha-la.
     * Caso o arquivo hibernate.cfg.xml esteja configurado para utilizar um DataSource gerenciado pelo servidor de aplicativo, este
     * m�todo ir� fazer uso dele. Caso contr�rio, ir� criar manualmente uma nova conex�o JDBC com o servidor de banco de dados.
     * 
     * @return uma Connection JDBC
     */
    public static Connection getConnection() {
    	/*
    	 * Abre o arquivo hibernate.cfg.xml para obter as configura��es de acesso ao banco de dados.
    	 */
		XmlFileReader xmlReader;
		try {
			xmlReader = new XmlFileReader( HibernateUtil.class.getResource( "/hibernate.cfg.xml" ) );
		} catch (Exception e) {
			throw new RuntimeException("N�o foi poss�vel abrir o arquivo /hibernate.cfg.xml para leitura.", e);
		}
        
		/*
		 * Se a origem da conex�o JDBC for um DataSource gerenciado pelo servidor de aplicativo, utiliza o nome JNDI do
		 * mesmo para se obter e repassar a conex�o.
		 */
        String jdbcDataSource = xmlReader.getNodeValue("//hibernate-configuration/session-factory/property[@name='connection.datasource']");
        if(jdbcDataSource != null) {
			try {
				Context ctx = new InitialContext();
				DataSource ds = (DataSource)ctx.lookup(jdbcDataSource);
				return ds.getConnection();
			} catch (NamingException e) {
				throw new RuntimeException("N�o foi poss�vel obter o objeto DataSource a partir do contexto JNDI.", e);
			} catch (SQLException e) {
				throw new RuntimeException("N�o foi poss�vel obter a conex�o JDBC a partir do objeto DataSource.", e);
			}
        }

        /*
         * L� as propriedades da conex�o JDBC utilizadas pelo Hibernate.
         */
        String driverName = xmlReader.getNodeValue( "//hibernate-configuration/session-factory/property[@name='connection.driver_class']" );
        String url = xmlReader.getNodeValue( "//hibernate-configuration/session-factory/property[@name='connection.url']" );
        String username = xmlReader.getNodeValue( "//hibernate-configuration/session-factory/property[@name='connection.username']" );
        String password = xmlReader.getNodeValue( "//hibernate-configuration/session-factory/property[@name='connection.password']" );

        /*
         * Cria manualmente uma conex�o JDBC com o servidor de banco de dados.
         */
        try {
			Class.forName( driverName );
			return DriverManager.getConnection( url, username, password );
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("A classe do driver de conex�es JDBC n�o foi encontrada.", e);
		} catch (SQLException e) {
			throw new RuntimeException("N�o foi poss�vel obter manualmente uma conex�o JDBC com o servidor de banco de dados.", e);
		}
    }

}