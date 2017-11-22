import React, { Component } from 'react';
import axios from 'axios';
import {BootstrapTable,TableHeaderColumn} from 'react-bootstrap-table';


class AllVehicles extends Component {
    constructor (props) {
        super(props);

        this.state = {Vehicles: []};

    }

    componentDidMount() {
        console.log('componentDidMount()');
        let self = this;
        const vehicleUrl = "http://localhost:8080/api/allvehicles";


        axios.get(vehicleUrl)
            .then(function (response) {
                console.log("=========");
                console.log(response);
                if (response.data) {
                    self.setState({
                        Vehicles: response.data
                    });
                }
            })
            .catch(function (error) {
                console.log(error);
            });
    }




    render(){
        return(
<div className="App">

                <div>
                    <BootstrapTable ref='table' data={this.state.Vehicles}>
                        <TableHeaderColumn dataField='vin'  isKey={true} dataSort={true}>VIN</TableHeaderColumn>
                        <TableHeaderColumn dataField='make' dataSort={true}>Make</TableHeaderColumn>
                        <TableHeaderColumn dataField='model' dataSort={true}>Model</TableHeaderColumn>
                        <TableHeaderColumn dataField='year' dataSort={true}>Year</TableHeaderColumn>
                        <TableHeaderColumn dataField='redlineRpm' dataSort={true}>Redline Rpm</TableHeaderColumn>
                        <TableHeaderColumn dataField='maxFuelVolume' dataSort={true}>Max Fuel Volume</TableHeaderColumn>
                        <TableHeaderColumn dataField='lastServiceDate' dataSort={true}>Last Service Date</TableHeaderColumn>
                    </BootstrapTable>


                </div>
</div>
                );



    }
}
export default AllVehicles;