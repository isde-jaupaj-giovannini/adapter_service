package com.unitn.adapter_service.resources;

import com.unitn.adapter_service.services.chart.ChartData;
import retrofit2.http.Body;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collections;
import java.util.List;

/**
 * Created by erinda on 2/7/16.
 */
@Path("/chart")
public class ChartRes {

    @POST
    @Produces({MediaType.APPLICATION_JSON })
    public ChartData generateChart(@Body List<Integer> ls){

        ChartData chartData = new ChartData();

        String chd = "";
        String chxl = "";

        int max = Collections.max(ls);

        for (Integer elem: ls) {
            chxl += "|" + elem;
            elem = (100 * elem) / max;

            chd += elem + ",";
        }

        chd = chd.substring(0, chd.length()-1);

        chartData.setUrl("http://chart.apis.google.com/chart?cht=r&chs=200x200&chd=t:" + chd + "&chco=FF0000,FF9900&chls=2.0,4.0,0.0|2.0,4.0,0.0&chxt=x&chxl=0:"+chxl+"&chxr=0,0.0,360.0");

        return chartData;

    }
}
