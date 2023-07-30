import { Component } from "react";
import ReactApexChart from "react-apexcharts";

export class ChartDiagnosis extends Component{

    constructor(props) {
        super(props);

        this.state = {
            series: [],
            options: {
            },
        };
    }

    componentWillReceiveProps(props){
        this.setState({
            series: [{
                name: 'Diagnostics',
                data: props.diagnoses.map((row)=>row.count)
            },],
            options:{
                chart: {
                    height: 350,
                    type: 'area'
                },
                dataLabels: {
                    enabled: false
                },
                stroke: {
                    curve: 'smooth'
                },
                xaxis: {
                    type: 'datetime',
                    categories: props.diagnoses.map((row)=>row.period)
                },
                tooltip: {
                    x: {
                        format: 'dd/MM/yy HH:mm'
                    },
                },
            }
        })
       
    }

    render() {
        return (
            <div className="container-fluid mt-5" id="chart">
                <ReactApexChart options={this.state.options} series={this.state.series} type="area" height={350} />
            </div>
        );
    }
}