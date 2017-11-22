import React, { Component } from 'react';
import {BarChart, Bar, XAxis, YAxis, CartesianGrid, Tooltip, Legend} from 'recharts';
import axios from 'axios';

class VehiclePlotHistory extends Component {

    constructor(props){

    super(props);

    this.state= {graphs:[]};}


    componentDidMount(){
        let self=this;
        const graphUrl="http://localhost:8080/api/vehicleplot"
        axios.get(graphUrl)
            .then(function (response) {
                if (response.data) {
                    self.setState({
                        graphs: response.data
                    });
                }
            })
            .catch(function (error) {
                console.log(error);
            });

    }

    render() {
        return (
            <div>
                <h3> Click on the plot to get details </h3>
                <div className="plot">
                    <h2> Fuel Volume plot </h2>

                        <select>
                            <option>select time</option>
                            <option>15 Minutes</option>
                            <option>30 Minutes</option>
                            <option> 1 hour</option>
                        </select>
                </div>
                <div>
                    <BarChart width={1000} height={300} data={this.state.graphs}
                              margin={{top: 5, right: 30, left: 20, bottom: 5}}>
                        <XAxis dataKey="timestamp"/>
                        <YAxis dataKey="fuelVolume"/>
                        <CartesianGrid strokeDasharray="3 3"/>
                        <Tooltip/>
                        <Legend />
                        <Bar dataKey="fuelVolume"  fill="#8884d8" />
                        <Bar dataKey="timestamp" fill="#82ca9d" />
                        <Bar dataKey="vin" fill="red" />
                    </BarChart></div>


<div className="plot"><h2>
    Engine Rpm plot
</h2>
    <select>
        <option>select time</option>
        <option>15 Minutes</option>
        <option>30 Minutes</option>
        <option> 1 hour</option>
    </select>
</div>
                <div>
                    <BarChart width={1000} height={300} data={this.state.graphs}
                              margin={{top: 5, right: 30, left: 20, bottom: 5}}>
                        <XAxis dataKey="timestamp"/>
                        <YAxis dataKey="engineRpm"/>
                        <CartesianGrid strokeDasharray="3 3"/>
                        <Tooltip/>
                        <Legend />
                        <Bar dataKey="engineRpm"  fill="#8884d8" />
                        <Bar dataKey="timestamp" fill="#82ca9d" />
                        <Bar dataKey="vin" fill="red" />
                    </BarChart></div>
            </div>
        );
    }
}
export default VehiclePlotHistory;