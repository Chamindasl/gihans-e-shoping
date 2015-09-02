/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gihans.gs.service.rest;

import java.net.URISyntaxException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import com.gihans.gs.model.vo.ReportVO;
import java.util.ArrayList;

@Stateless
@Path("/report")
public class ReportRest {

    @PersistenceContext(unitName = "gihans_PU")
    private EntityManager em;

    @GET
    @Path("sales")
    @Produces("application/json")
    public List<ReportVO> getSales() throws URISyntaxException {
        final List<ReportVO> reportVOs = new ArrayList<>();
        final GregorianCalendar calendar = new java.util.GregorianCalendar();
        calendar.setTime(new Date());
        final int yearFrom = calendar.get(Calendar.YEAR) - 5;
        final int yearTo = calendar.get(Calendar.YEAR);
        final List<Object[]> dbResult = em.createQuery(""
                + "SELECT YEAR(c.paymentReceivedDate), MONTH(c.paymentReceivedDate), SUM(c.amount)"
                + " FROM ClientOrder c"
                + " WHERE YEAR(c.paymentReceivedDate)>=:yearFrom AND YEAR(c.paymentReceivedDate)<=:yearTo"
                + " GROUP BY YEAR(c.paymentReceivedDate), MONTH(c.paymentReceivedDate)")
                .setParameter("yearFrom", yearFrom)
                .setParameter("yearTo", yearTo)
                .getResultList();
        int j = 0;
        for (int year = yearFrom; year <= yearTo; year++) {
            final double[] result = new double[12];
            double total = 0;
            for (int month = 0; month < 12; month++) {
                double k = 0d;
                if (j < dbResult.size() && year == ((int) dbResult.get(j)[0]) && month == (((int) dbResult.get(j)[1]) - 1)) {
                    k = (double) dbResult.get(j++)[2];
                }
                result[month] = k;
                total += k; 
            }
            final ReportVO oneReportVO = new ReportVO();
            oneReportVO.year = year;
            oneReportVO.values = result;
            oneReportVO.total = total;
            reportVOs.add(oneReportVO);
        }
        return reportVOs;
    }

}
