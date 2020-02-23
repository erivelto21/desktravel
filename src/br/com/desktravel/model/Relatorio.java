package br.com.desktravel.model;

import java.io.OutputStream;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;

public class Relatorio {
	
	private Connection conexao;
	private HttpServletResponse httpServletResponse;
	
	public Relatorio(Connection conexao, HttpServletResponse httpServletResponse){
		this.conexao = conexao;
		this.httpServletResponse = httpServletResponse;
	}
	
	public void gerarPdf(String jrxml, 
	        Map<String, Object> parametros, OutputStream saida){
		
		try{
			JasperReport jasper = JasperCompileManager.compileReport(jrxml);

			
			JasperPrint	print = JasperFillManager.fillReport(jasper, parametros, this.conexao);
			

//	        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\"" + "Relatorio de subordinados.pdf" + "\"");

			JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, saida);

            exporter.exportReport();
		}catch (Exception e) {
			System.out.println(e);
		}
	}
}
