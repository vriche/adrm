<html>
<head>
<link rel="stylesheet" href="sample.css" type="text/css"/>
<title>Timeseries Chart Creation Code</title>
</head>
<body>
<img src="images/top_bar.png" width=1004 height=75 border=0>
<table border=0>
	<tr>
	<td width=170><img src="images/spacer.png" width=170 height=1></td>
	<td>
	<h2>Timeseries Chart Creation Code</h2>
	From org.jfree.chart.demo.servlet.WebHitChart (See also xy_chart.jsp)

<xmp>
public static String generateXYChart(String section, HttpSession session, PrintWriter pw) {
    String filename = null;
    try {
        //  Retrieve list of WebHits
        WebHitDataSet whDataSet = new WebHitDataSet();
        ArrayList list = whDataSet.getDataByHitDate(section);

        //  Throw a custom NoDataException if there is no data
        if (list.size() == 0) {
            System.out.println("No data has been found");
            throw new NoDataException();
        }

        //  Create and populate an XYSeries Collection
        XYSeries dataSeries = new XYSeries("Hits");
        Iterator iter = list.listIterator();
        while (iter.hasNext()) {
            WebHit wh = (WebHit)iter.next();
            dataSeries.add(wh.getHitDate().getTime(),wh.getHitCount());
        }
        XYSeriesCollection xyDataset = new XYSeriesCollection(dataSeries);

        //  Create tooltip and URL generators
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.UK);

        StandardXYToolTipGenerator ttg = new StandardXYToolTipGenerator(
                StandardXYToolTipGenerator.DEFAULT_TOOL_TIP_FORMAT,
                sdf, NumberFormat.getInstance());
        TimeSeriesURLGenerator urlg = new TimeSeriesURLGenerator(
                sdf, "pie_chart.jsp", "series", "hitDate");

        //  Create the chart object
        ValueAxis timeAxis = new DateAxis("");
        NumberAxis valueAxis = new NumberAxis("");
        valueAxis.setAutoRangeIncludesZero(false);  // override default
        StandardXYItemRenderer renderer = new StandardXYItemRenderer(
                StandardXYItemRenderer.LINES + StandardXYItemRenderer.SHAPES,
                ttg, urlg);
        renderer.setShapesFilled(true);
        XYPlot plot = new XYPlot(xyDataset, timeAxis, valueAxis, renderer);
        JFreeChart chart = new JFreeChart("", JFreeChart.DEFAULT_TITLE_FONT, plot, false);
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
		<td align=left><a href="xy_chart.jsp">Back to the chart</a></td>
		<td align=right><a href="index.html">Back to the home page</a></td>
		</tr>
	</table>

	</td>
	</tr>
</table>
</body>
</html>
