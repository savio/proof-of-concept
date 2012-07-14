package com.indhio.jfreechart;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.TickUnit;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
import org.jfree.ui.ApplicationFrame;

/**
 * Classe para abrir os testes com os graficos.
 * 
 * @author Vagner Planello vagner (ponto) planello (arroba) gmail (ponto) com
 * 
 */
public class Charts extends ApplicationFrame {

	/**
     *
     */
	private static final long serialVersionUID = -1807674325091843844L;

	/**
	 * Metodo main que inicia a geracao dos graficos.
	 * 
	 * @param args
	 *          - noargs
	 */
	public static void main(final String[] args) {
		Charts chart = new Charts("Teste Bar Chart");
		chart.pack();
		chart.setVisible(true);
	}

	/**
	 * Cria um grafico do tipo time serie.
	 * 
	 * @return - o Objeto JFreeChart com o grafico
	 */
	public static JFreeChart getTimeSerie() {
		JFreeChart chart = ChartFactory.createTimeSeriesChart("Historico F-1 - Construtores", "Ano", "Posição", getTimeSet(), true, false, false);

		/*
		 * Parte 2 - Seta o range axis como inverted; Seta o range para 0 - 12 no range axis e para Year(1997) - Year(2009) no domain axis Seta o tamanho do tick pra 1 unidade no range axis
		 */
		chart.getXYPlot().getRangeAxis().setInverted(true);
		chart.getXYPlot().getRangeAxis().setRange(0, 12);
		chart.getXYPlot().getDomainAxis().setRange(new Year(1997).getMiddleMillisecond(), new Year(2009).getFirstMillisecond());
		chart.getXYPlot().getRangeAxis().setStandardTickUnits(new TickUnitSource() {
			public TickUnit getCeilingTickUnit(final TickUnit arg0) {
				return new NumberTickUnit(1);
			}

			public TickUnit getCeilingTickUnit(final double arg0) {
				return new NumberTickUnit(1);
			}

			public TickUnit getLargerTickUnit(final TickUnit arg0) {
				return new NumberTickUnit(1);
			}

		});

		/*
		 * Parte 3 - Adiciona anotacoes para as mudancas de nomes de equipes Adiciona anotacoes para as saidas de equipes Adiciona anotacoes para fatos que modificaram o resultado
		 */
		XYPlot plot = chart.getXYPlot();
		plot.addAnnotation(getAnnotation("Tyrrel", new Year(1998).getFirstMillisecond(), 10));
		plot.addAnnotation(getAnnotation("Stewart", new Year(1999).getFirstMillisecond(), 4));
		plot.addAnnotation(getAnnotation("Benneton", new Year(2001).getFirstMillisecond(), 7));
		plot.addAnnotation(getAnnotation("Jaguar", new Year(2004).getFirstMillisecond(), 7));
		plot.addAnnotation(getAnnotation("BAR", new Year(2005).getFirstMillisecond(), 7));
		plot.addAnnotation(getAnnotation("Sauber", new Year(2005).getFirstMillisecond(), 8));
		plot.addAnnotation(getAnnotation("Jordan", new Year(2005).getFirstMillisecond(), 9));
		plot.addAnnotation(getAnnotation("Minardi", new Year(2005).getFirstMillisecond(), 10));
		plot.addAnnotation(getAnnotation("MF1", new Year(2006).getFirstMillisecond(), 10));
		plot.addAnnotation(getAnnotation("Spyker", new Year(2007).getFirstMillisecond(), 10, Color.WHITE));

		plot.addAnnotation(getAnnotation("Saiu", new Year(2001).getFirstMillisecond(), 9, Color.RED));
		plot.addAnnotation(getAnnotation("Saiu", new Year(2002).getFirstMillisecond(), 9, Color.RED));
		plot.addAnnotation(getAnnotation("Perdeu Pontos", new Year(2007).getFirstMillisecond(), 11, Color.RED));
		plot.addAnnotation(getAnnotation("Saiu", new Year(2008).getFirstMillisecond(), 11, Color.RED));

		/*
		 * Parte 4 - Coloca cores mais relacionadas com as cores das equipes sempre que possivel Aumenta a grossura da linha
		 */
		plot.getRenderer().setSeriesPaint(0, Color.DARK_GRAY);
		plot.getRenderer().setSeriesPaint(1, Color.RED);
		plot.getRenderer().setSeriesPaint(2, Color.BLUE);
		plot.getRenderer().setSeriesPaint(3, Color.ORANGE);
		plot.getRenderer().setSeriesPaint(4, Color.YELLOW);
		plot.getRenderer().setSeriesPaint(5, Color.BLUE.darker());
		plot.getRenderer().setSeriesPaint(6, Color.PINK);
		plot.getRenderer().setSeriesPaint(7, Color.MAGENTA.darker());
		plot.getRenderer().setSeriesPaint(8, Color.GREEN);
		plot.getRenderer().setSeriesPaint(9, Color.GREEN.darker());
		plot.getRenderer().setSeriesPaint(10, Color.RED.darker());
		plot.getRenderer().setSeriesPaint(11, Color.CYAN);
		plot.getRenderer().setSeriesPaint(12, Color.GRAY);

		for (int i = 0; i <= 12; i++) {
			plot.getRenderer().setSeriesStroke(i, new BasicStroke(3f));
		}

		/*
		 * Extra - Codigo pra salvar uma imagem do grafico como png
		 */
		// ImageEncoder ie = ImageEncoderFactory.newInstance(ImageFormat.PNG);
		// try {
		// ie.encode(chart.createBufferedImage(800, 600), new FileOutputStream("f1_01.png"));
		// } catch (FileNotFoundException e) {
		// e.printStackTrace();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		return chart;
	}

	/**
	 * Construtor da classe que faz a chamada para obter o grafico e coloca no panel.
	 * 
	 * @param title
	 *          titulo do painel
	 */
	public Charts(final String title) {
		super(title);
		JFreeChart chart = getTimeSerie();
		ChartPanel panel = new ChartPanel(chart);
		panel.setPreferredSize(new Dimension(800, 600));
		setContentPane(panel);
	}

	/**
	 * Cria uma anotacao.
	 * 
	 * @param text
	 *          Texto da anotacao
	 * @param x
	 *          posicao x da anotacao
	 * @param y
	 *          posicao y da anotacao
	 * @param color
	 *          cor que a anotacao deve ter
	 * @return objeto XYTextAnnotation com o conteudo da anotacao
	 */
	public static XYTextAnnotation getAnnotation(final String text, final double x, final double y, final Color color) {
		XYTextAnnotation cta = new XYTextAnnotation(text, x, y);
		Font font = new Font(Font.SANS_SERIF, Font.BOLD, 12);
		cta.setFont(font);
		cta.setPaint(color);
		return cta;
	}

	/**
	 * Cria uma anotacao com cor default.
	 * 
	 * @param text
	 *          Texto da anotacao
	 * @param x
	 *          posicao x da anotacao
	 * @param y
	 *          posicao y da anotacao
	 * @return objeto XYTextAnnotation com o conteudo da anotacao
	 */
	public static XYTextAnnotation getAnnotation(final String text, final double x, final double y) {
		return getAnnotation(text, x, y, Color.DARK_GRAY);
	}

	/**
	 * 
	 * @return A colecao de dados pra popular o grafico
	 */
	public static TimeSeriesCollection getTimeSet() {
		TimeSeriesCollection ts = new TimeSeriesCollection();

		Year _1998 = new Year(1998);
		Year _1999 = new Year(1999);
		Year _2000 = new Year(2000);
		Year _2001 = new Year(2001);
		Year _2002 = new Year(2002);
		Year _2003 = new Year(2003);
		Year _2004 = new Year(2004);
		Year _2005 = new Year(2005);
		Year _2006 = new Year(2006);
		Year _2007 = new Year(2007);
		Year _2008 = new Year(2008);

		TimeSeries mc = new TimeSeries("McLaren", Year.class);
		mc.add(_1998, 1);
		mc.add(_1999, 2);
		mc.add(_2000, 2);
		mc.add(_2001, 2);
		mc.add(_2002, 3);
		mc.add(_2003, 3);
		mc.add(_2004, 5);
		mc.add(_2005, 2);
		mc.add(_2006, 3);
		mc.add(_2007, 11);
		mc.add(_2008, 2);
		ts.addSeries(mc);

		TimeSeries fe = new TimeSeries("Ferrari", Year.class);
		fe.add(_1998, 2);
		fe.add(_1999, 1);
		fe.add(_2000, 1);
		fe.add(_2001, 1);
		fe.add(_2002, 1);
		fe.add(_2003, 1);
		fe.add(_2004, 1);
		fe.add(_2005, 3);
		fe.add(_2006, 2);
		fe.add(_2007, 1);
		fe.add(_2008, 1);
		ts.addSeries(fe);

		TimeSeries wi = new TimeSeries("Williams", Year.class);
		wi.add(_1998, 3);
		wi.add(_1999, 5);
		wi.add(_2000, 3);
		wi.add(_2001, 3);
		wi.add(_2002, 2);
		wi.add(_2003, 2);
		wi.add(_2004, 4);
		wi.add(_2005, 5);
		wi.add(_2006, 8);
		wi.add(_2007, 4);
		wi.add(_2008, 8);
		ts.addSeries(wi);

		TimeSeries fi = new TimeSeries("Force India", Year.class);
		fi.add(_1998, 4);
		fi.add(_1999, 3);
		fi.add(_2000, 6);
		fi.add(_2001, 5);
		fi.add(_2002, 6);
		fi.add(_2003, 9);
		fi.add(_2004, 9);
		fi.add(_2005, 9);
		fi.add(_2006, 10);
		fi.add(_2007, 10);
		fi.add(_2008, 10);
		ts.addSeries(fi);

		TimeSeries rn = new TimeSeries("Renault", Year.class);
		rn.add(_1998, 5);
		rn.add(_1999, 6);
		rn.add(_2000, 4);
		rn.add(_2001, 7);
		rn.add(_2002, 4);
		rn.add(_2003, 4);
		rn.add(_2004, 3);
		rn.add(_2005, 1);
		rn.add(_2006, 1);
		rn.add(_2007, 3);
		rn.add(_2008, 4);
		ts.addSeries(rn);

		TimeSeries bm = new TimeSeries("BMW", Year.class);
		bm.add(_1998, 6);
		bm.add(_1999, 8);
		bm.add(_2000, 8);
		bm.add(_2001, 4);
		bm.add(_2002, 5);
		bm.add(_2003, 6);
		bm.add(_2004, 6);
		bm.add(_2005, 8);
		bm.add(_2006, 5);
		bm.add(_2007, 2);
		bm.add(_2008, 3);
		ts.addSeries(bm);

		TimeSeries ar = new TimeSeries("Arrows", Year.class);
		ar.add(_1998, 7);
		ar.add(_1999, 9);
		ar.add(_2000, 7);
		ar.add(_2001, 10);
		ar.add(_2002, 9);
		ts.addSeries(ar);

		TimeSeries rb = new TimeSeries("Red Bull", Year.class);
		rb.add(_1998, 8);
		rb.add(_1999, 4);
		rb.add(_2000, 9);
		rb.add(_2001, 8);
		rb.add(_2002, 7);
		rb.add(_2003, 7);
		rb.add(_2004, 7);
		rb.add(_2005, 6);
		rb.add(_2006, 7);
		rb.add(_2007, 5);
		rb.add(_2008, 7);
		ts.addSeries(rb);

		TimeSeries pt = new TimeSeries("Prost", Year.class);
		pt.add(_1998, 9);
		pt.add(_1999, 7);
		pt.add(_2000, 11);
		pt.add(_2001, 9);
		ts.addSeries(pt);

		TimeSeries ho = new TimeSeries("Honda", Year.class);
		ho.add(_1998, 10);
		ho.add(_1999, 11);
		ho.add(_2000, 5);
		ho.add(_2001, 6);
		ho.add(_2002, 8);
		ho.add(_2003, 5);
		ho.add(_2004, 2);
		ho.add(_2005, 7);
		ho.add(_2006, 4);
		ho.add(_2007, 8);
		ho.add(_2008, 9);
		ts.addSeries(ho);

		TimeSeries tr = new TimeSeries("Toro Rosso", Year.class);
		tr.add(_1998, 11);
		tr.add(_1999, 10);
		tr.add(_2000, 10);
		tr.add(_2001, 11);
		tr.add(_2002, 10);
		tr.add(_2003, 10);
		tr.add(_2004, 10);
		tr.add(_2005, 10);
		tr.add(_2006, 9);
		tr.add(_2007, 7);
		tr.add(_2008, 6);
		ts.addSeries(tr);

		TimeSeries to = new TimeSeries("Toyota", Year.class);
		to.add(_2002, 11);
		to.add(_2003, 8);
		to.add(_2004, 8);
		to.add(_2005, 4);
		to.add(_2006, 6);
		to.add(_2007, 6);
		to.add(_2008, 5);
		ts.addSeries(to);

		TimeSeries sa = new TimeSeries("Super Aguri", Year.class);
		sa.add(_2006, 11);
		sa.add(_2007, 9);
		sa.add(_2008, 11);
		ts.addSeries(sa);

		return ts;
	}
}