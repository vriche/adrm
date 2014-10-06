<html>
<head>
<link rel="stylesheet" href="sample.css" type="text/css"/>
<title>Timeseries Stacked Area Chart Creation Code</title>
</head>
<body>
<img src="images/top_bar.png" width=1004 height=75 border=0>
<table border=0>
	<tr>
	<td width=170><img src="images/spacer.png" width=170 height=1></td>
	<td>
	<h2>Timeseries Stacked Area Chart Creation Code</h2>
	From org.jfree.chart.demo.servlet.WebHitChart (See also xy_chart.jsp)

<xmp>
public static String generateXYAreaChart(HttpSession session, PrintWriter pw) {
    String filename = null;
    try {
        //  Retrieve list of WebHits for each section and populate a TableXYDataset
        WebHitDataSet whDataSet = new WebHitDataSet();
        ArrayList sections = whDataSet.getSections();
        Iterator sectionIter = sections.iterator();
        DefaultTableXYDataset dataset = new DefaultTableXYDataset();
        while (sectionIter.hasNext()) {
            String section = (String)sectionIter.next();
            ArrayList list = whDataSet.getDataByHitDate(section);
            XYSeries dataSeries = new XYSeries(section, true, false);
            Iterator webHitIter = list.iterator();
            while (webHitIter.hasNext()) {
                WebHit webHit = (WebHit)webHitIter.next();
                dataSeries.add(webHit.getHitDate().getTime(), webHit.getHitCount());
            }
            dataset.addSeries(dataSeries);
        }

        //  Throw a custom NoDataException if there is no data
        if (dataset.getItemCount() == 0) {
            System.out.println("No data has been found");
            throw new NoDataException();
        }

        //  Create tooltip and URL generators
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.UK);
        StandardXYToolTipGenerator ttg = new StandardXYToolTipGenerator(
                StandardXYToolTipGenerator.DEFAULT_TOOL_TIP_FORMAT,
                sdf, NumberFormat.getInstance());
        TimeSeriesURLGenerator urlg = new TimeSeriesURLGenerator(
                sdf, "bar_chart.jsp", "series", "hitDate");

        //  Create the X-Axis
        DateAxis xAxis = new DateAxis(null);
        xAxis.setLowerMargin(0.0);
        xAxis.setUpperMargin(0.0);

        //  Create the X-Axis
        NumberAxis yAxis = new NumberAxis(null);
        yAxis.setAutoRangeIncludesZero(true);

        //  Create the renderer
        StackedXYAreaRenderer renderer =
                new StackedXYAreaRenderer(XYAreaRenderer.AREA_AND_SHAPES, ttg, urlg);
        renderer.setSeriesPaint(0, new Color(255, 255, 180));
        renderer.setSeriesPaint(1, new Color(206, 230, 255));
        renderer.setSeriesPaint(2, new Color(255, 230, 230));
        renderer.setSeriesPaint(3, new Color(206, 255, 206));
        renderer.setShapePaint(Color.gray);
        renderer.setShapeStroke(new BasicStroke(0.5f));
        renderer.setShape(new Ellipse2D.Double(-3, -3, 6, 6));
        renderer.setOutline(true);

        //  Create the plot
        XYPlot plot = new XYPlot(dataset, xAxis, yAxis, renderer);
        plot.setForegroundAlpha(0.65f);

        //  Reconfigure Y-Axis so the auto-range knows that the data is stacked
        yAxis.configure();

        //  Create the chart
        JFreeChart chart = new JFreeChart(null, JFreeChart.DEFAULT_TITLE_FONT, plot, true);
        chart.setBackgroundPaint(java.awt.Color.white);

        //  Write the chart image to the temporary directory
        ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
        filename = ServletUtilities.saveChartAsPNG(chart, 500, 300, info, session);

        //  Write the image map to the PrintWriter
        ChartUtilities.writeImageMap(pw, filename, info);
        pw.flush();


    } catch (NoDataException e) {
        System.out.println(e.toString());
        filename = "public_nodata_500x300.png";
    } catch (Exception e) {
        System.out.println("Exception - " + e.toString());
        e.printStackTrace(System.out);
        filename = "public_error_500x300.png";
    }
    return filename;
}
</xmp>

	<table border=0 cellpadding=2 width=400>
		<tr>
		<td align=left><a href="xy_area_chart.jsp">Back to the chart</a></td>
		<td align=right><a href="index.html">Back to the home page</a></td>
		</tr>
	</table>

	</td>
	</tr>
</table>
</body>
</html>
