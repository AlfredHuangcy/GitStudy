package sfa.app.test;

import java.io.IOException;
import jp.co.worksap.printer.common.CommonPrinter;
import jp.co.worksap.printer.common.ReportUtilPlus;

public class SalaryPrinter {

	private CommonPrinter commonPrinter;
	private int lineCount = 0;

	public SalaryPrinter (CustResourceHolder resourceHolder) throws IOException{

		commonPrinter = new CommonPrinter(resourceHolder.getOutputFileName(), "UTF-8");
		printHeader();

	}

	public void printSvainJhSampleDto(SvainJhSampleDto svain) throws IOException {

		StringBuffer stringBuffer = new StringBuffer();
	
		stringBuffer.append(ReportUtilPlus.limitedString(svain.getSya_bg(), 7));
	
		stringBuffer.append("   ");
	
		stringBuffer.append(ReportUtilPlus.limitedString(svain.getSya_nm(), 20));
	
		stringBuffer.append("   ");
	
		stringBuffer.append(ReportUtilPlus.limitedString(svain.getJig_cd(), 4));
	
		stringBuffer.append("   ");
	
		stringBuffer.append(ReportUtilPlus.limitedString(svain.getBu_cd(), 4));
	
		stringBuffer.append("   ");
	
		stringBuffer.append(ReportUtilPlus.limitedString(svain.getKa_cd(), 4));
	
		stringBuffer.append("   ");
	
		stringBuffer.append(ReportUtilPlus.formatNumNoComma(svain.getKihon_kyu(), 17));
	
		stringBuffer.append("   ");
	
		stringBuffer.append(ReportUtilPlus.formatNumNoComma(svain.getKazoku_kyu(),17));
	
		stringBuffer.append("   ");
	
		stringBuffer.append(ReportUtilPlus.formatNumNoComma(svain.getYakusyoku_kyu(), 17));
	
		stringBuffer.append("   ");
	
		stringBuffer.append(ReportUtilPlus.formatNumNoComma(svain.getTsujo_zan_jikan(), 5));
	
		stringBuffer.append("   ");
	
		stringBuffer.append(ReportUtilPlus.formatNumNoComma(svain.getSinya_zan_jikan(), 5));
	
		stringBuffer.append("   ");
	
		printLine(stringBuffer.toString());

}
	
	public void printTotalByKa(String totalByKa) throws IOException {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(ReportUtilPlus.limitedString("",100));
		stringBuffer.append(ReportUtilPlus.limitedString("课合计",7));
		stringBuffer.append(ReportUtilPlus.limitedString(totalByKa, 7));
		stringBuffer.append("   ");
		printLine(stringBuffer.toString());
	}
	
	public void printTotalByBu(String totalByBu) throws IOException {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(ReportUtilPlus.limitedString("",100));
		stringBuffer.append(ReportUtilPlus.limitedString("部合计",7));
		stringBuffer.append(ReportUtilPlus.limitedString(totalByBu, 7));
		stringBuffer.append("   ");
		printLine(stringBuffer.toString());
	}
	
	public void printTotalByJig(String totalByJin) throws IOException {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(ReportUtilPlus.limitedString("",100));
		stringBuffer.append(ReportUtilPlus.limitedString("事业所合计",14));
		stringBuffer.append(ReportUtilPlus.limitedString(totalByJin, 7));
		stringBuffer.append("   ");
		printLine(stringBuffer.toString());
	}
	
	public void printTotal(String total) throws IOException {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(ReportUtilPlus.limitedString("",100));
		stringBuffer.append(ReportUtilPlus.limitedString("全社合计",7));
		stringBuffer.append(ReportUtilPlus.limitedString(total, 7));
		stringBuffer.append("   ");
		printLine(stringBuffer.toString());
	}

	private void printHeader() throws IOException {

		lineCount = 0;

		printLine("");

		printLine("　　　　　　　　　　☆☆☆　支給一覧　☆☆☆");

		printLine("");

		printLine("　　　社員番号　　　社員氏名　　　事業所コード　　　部コード　　　課コード　　　　　基本給　　　　　家族手当　　　　　役職手当　　　通常残業時間　　　深夜残業時間　　　　残業手当　　　　総支給　　　　");

		printLine("");

	}

	private void printLine(String text) throws IOException{

			if(lineCount >= 60){

				commonPrinter.newPage();

				printHeader();

				}

			lineCount++;

			commonPrinter.writeLine(text);

	}

	public void close() throws IOException{

		commonPrinter.close();

	}

}
