
import React, { Component } from 'react';
import axios from 'axios';
import {BootstrapTable,TableHeaderColumn} from 'react-bootstrap-table';

    class HighAlerts extends Component {
        constructor (props) {
            super(props);

            this.state = {Alertcount: []};

        }


        componentDidMount() {
            console.log('componentDidMount()');
            let self = this;

            const alertUrl = "http://localhost:8080/api/alertcount";






            axios.get(alertUrl)
                .then(function (response) {
                    if (response.data) {
                        self.setState({
                            Alertcount: response.data
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
            <div>

                <div>
                    <BootstrapTable ref='table' data={this.state.Alertcount}>
                        <TableHeaderColumn dataField='vin' isKey={true} dataSort={true}>VIN</TableHeaderColumn>
                        <TableHeaderColumn dataField='count' dataSort={true}>High Alert Count</TableHeaderColumn>
                        <TableHeaderColumn dataField='timestamp' dataSort={true}>Timestamp</TableHeaderColumn>
                    </BootstrapTable>
                </div>
            </div>
            </div>
        );
    }
}

export default HighAlerts;