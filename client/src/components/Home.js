import React, { Component } from 'react';
import {Link} from 'react-router'

import './Home.css'


class Home extends Component {



    render(){

        return(
            <div className="App">

                <div className="App-header">
                    <h3>CAR TRACKER</h3>
                </div>
                        <div className="flex-container">

                           <ul>
                               <li><Link to={"/vehicleList"} activeStyle={{color:"blue"}} activeClassName={"active"} >Vehicle List</Link></li>
                               <li><Link to={"/highAlerts"} activeStyle={{color: "blue"}} activeClassName={"active"}>Vehicle High Alerts</Link></li>
                               <li><Link to={"/alertLocation"} activeStyle={{color: "blue"}} activeClassName={"active"}>Vehicle Alert Location</Link></li>
                               <li><Link to={"/vehiclelocation"} activeStyle={{color: "blue"}} activeClassName={"active"}>Vehicle Location</Link></li>
                               <li><Link to={"/vehicleplot"} activeStyle={{color: "blue"}} activeClassName={"active"}>Vehicle Plot History</Link></li>
                           </ul>
                            </div>


                <div>
                    {this.props.children}
                </div>


            </div>

        );

    }

}



export default Home;