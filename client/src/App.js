import React, { Component } from 'react';
import Home from './components/Home'
import HighAlerts from './components/HighAlerts'
import AllVehicles from './components/AllVehicles'
import AlertLocation from './components/AlertLocation'
import VehicleLocation from './components/VehicleLocation'
import VehiclePlotHistory from './components/VehiclePlotHistory'
import { Router, Route,browserHistory} from 'react-router'
import './App.css';


class App extends Component {


       render(){

                return(

        <div className="App-intro">
            <Router history={browserHistory}>
            <Route path={"/"} component={Home}>

                <Route path={"vehicleList"} component={AllVehicles}/>
                <Route path={"highAlerts"} component={HighAlerts}/>
                <Route path={"alertLocation"} component={AlertLocation}/>
                <Route path={"vehiclelocation"} component={VehicleLocation}/>
                <Route path={"vehicleplot"} component={VehiclePlotHistory}/>
            </Route>
            </Router>

          </div>

        );}}


export default App;