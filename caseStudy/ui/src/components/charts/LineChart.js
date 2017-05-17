/**
 * Copyright 2017 Goldman Sachs.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import React from 'react';
import Highcharts from 'highcharts';
import Input from '../Input.js';

class LineChart extends React.Component {
    constructor(props) {
        super(props);
        this.highchartsOptions = {
      title: {
        text: 'Price Per Day'
      },
      xAxis: {
        categories: []
      },
      yAxis: {
        title: {
          text: 'Price'
        }
      },
      series: [{
          name: 'Day',
          data: [1,2,3,4,5,6,7,8,10]
      }]
    }
    }

    componentDidMount() {
        Highcharts.chart('chart', this.highchartsOptions);
/*        Highcharts.chart('chart', {

            TODO
            Create a highcharts line chart of your choosing (e.g. https://www.highcharts.com/demo/line-time-series for a demo).

            series: [{
                name: 'Prices',
                data: this.props.data
            }]
        });
*/
    }

    componentWillReceiveProps(props) {
        console.log("New data received to redraw chart.");
        var start_date = new Date(this.props.start);
        var end_date = new Date(this.props.end);
        var numDays = end_date-start_date+1;
        var arrX = [];
        arrX += [start_date];
        // var x_axis_length = (Date.UTC(end_date[-1:-5], end_date[0:2], end_date[3:5]) - Date.UTC(start_date[-1:-5], start_date[0:2], start_date[3:5]))/86400000;
        var i = 1;
        var currentDate = arrX[-1];
        while (i < numDays){
            arrX += [currentDate + 1];
            i++;
            currentDate = arrX[-1];
        }
        this.highchartsOptions.xAxis.categories=arrX;
        var data = this.props.data;
        this.chart.series[0].setData(data);

        /**
         * TODO
         * Parse the data received from props, a Javascript object, to map to a Javascript array
         * required by the type of line chart chosen and set it in the series. Use Date.UTC(..)
         * to create the x-axis.
         */
        
        /**
         * TODO
         * Uncomment the line below to pass the data be displayed to the series
         * 
         **/
         
    }

    componentWillUnmount() {
        this.chart.destroy();
    }


    render() {
        return (
            <div id='chart'></div>
        )
    }
}

export default LineChart;
