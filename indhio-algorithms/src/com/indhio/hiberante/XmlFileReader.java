/*
 * Created on 11/04/2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.indhio.hiberante;

import java.net.URL;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

/**
 * @author patrick
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class XmlFileReader
{
    private Document document;
    
    
    public XmlFileReader( URL fileUrl ) throws Exception
    {
        SAXReader reader = new SAXReader();
        
        try
        {
            document = reader.read( fileUrl );
        }
        catch( DocumentException e )
        {
            throw new Exception( "Could not read XML file. Reason: " + e.getMessage() ); 
        }
    }
    
    /**
     * Retorna o conteúdo de uma tag do documento XML baseando-se em um caminho XPath.
     * Exemplo:
     * <br><br>
     * <code>
     * <?xml version="1.0"?>
     * <AGENDA>
     * &nbsp;&nbsp;&nbsp;&nbsp;&ltCONTATO&gt<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&ltNOME>Fulano de Tal&lt/NOME&gt<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&ltENDERECO&gt<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&ltRUA>Rua Exemplo&lt/RUA&gt<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&ltBAIRRO>Bairro Exemplo&lt/BAIRRO&gt<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt/ENDERECO&gt<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;&lt/CONTATO&gt<br>
     * </AGENDA>
     * </code>
     * <br><br>
     * Para resgatar o conteúdo da tag NOME fazemos uma chamada ao método desta forma:<br>
     * <code>getNodeValue( "//AGENDA/CONTATO/NOME" )</code><br><br>
     * Para resgatar o conteúdo da tag RUA fazemos uma chamada na seguinte forma:<br>
     * <code>getNodeValue( "//AGENDA/CONTATO/ENDERECO/RUA" );</code>
     * @param xPath
     * @return
     */
    public String getNodeValue( String xPath )
    {
        Node node = document.selectSingleNode( xPath );
        if(node != null)
        	return node.getText();
        else
        	return null;
    }
}

