import React, { Component } from 'react';
import {withGoogleMap, GoogleMap,Marker,InfoWindow} from 'react-google-maps';
import MarkerClusterer from "react-google-maps/lib/addons/MarkerClusterer";
import axios from 'axios';

const SimpleMapExampleGoogleMap = withGoogleMap(props => (
    <GoogleMap
        defaultZoom={8}
        defaultCenter={{ lat: -34.397, lng: 150.644 }}
        onClick={props.onMapClick}
    >
        <MarkerClusterer
            averageCenter
            enableRetinaIcons
            gridSize={60}
        >
            {props.markers.map(loc => (
                <Marker
                    position={{ lat: loc.latitude, lng: loc.longitude }}
                    key={loc.latitude}  onClick={()=> props.onMarkCl(loc)}
                >{(loc.showInfo && <InfoWindow
                onCloseClick={()=>props.onMarkerClose(loc)}>

                <div><h5>Priority: {loc.priority}</h5>
                <h5>Timestamp: {loc.timestamp}</h5>
                <h5>Vin: {loc.vin}</h5>
                </div></InfoWindow>)} </Marker>
            ))}
        </MarkerClusterer>
    </GoogleMap>
));

class AlertLocation extends Component {
    constructor(props){
        super(props);
        this.state={markers:[]};
        this.handleMarkerClick=this.handleMarkerClick.bind(this);
        this.handleMarkerClose=this.handleMarkerClose.bind(this);
        this.handleMarkerClose2=this.handleMarkerClose2.bind(this);

    }

    componentDidMount() {
        console.log('componentDidMount()');
        let self = this;
        const locationUrl="http://localhost:8080/api/alertlocation";
        axios.get(locationUrl)
            .then(function (response) {
                if (response.data) {
                    self.setState({
                        markers: response.data
                    });
                }
            })
            .catch(function (error) {
                console.log(error);
            });
    }

    handleMarkerClick=(targetMarker)=> {


        console.log(targetMarker)
        this.setState({
            markers: this.state.markers.map((loc) => {
                if (loc=== targetMarker) {
                    return {
                        ...loc,
                        showInfo: true
                    }
                } else {
                    return {
                        ...loc,
                        showInfo: false
                    }
                }

            })
        })
    }
    handleMarkerClose=(targetMarker)=> {
        this.setState({
            markers:this.state.markers.map((marker) => {
                if (marker === targetMarker) {
                    return {
                        ...marker,
                        showInfo: false
                    }
                }
                return marker
            })
        })
    }
    handleMarkerClose2=(targetMarker)=> {
        console.log(this.state.markers);
        this.setState({
            markers:this.state.markers.map((marker) => {
                if (targetMarker) {
                    return {
                        ...marker,

                        showInfo: false
                    }
                }
 return marker
            })
        })

    }
        render()
        {

return(
    <div>
        <h3>Click on the marker to view vehicle alert details</h3>
        <SimpleMapExampleGoogleMap
            containerElement={
                <div style={{ height: `1000px` }} />
            }
            mapElement={
                <div style={{ height: `1000px` }} />
            }

            markers={this.state.markers}
            onMapClick={this.handleMarkerClose2.bind(this)}
            onMarkerClose={this.handleMarkerClose.bind(this)} onMarkCl={this.handleMarkerClick.bind(this)}
        />

    </div>
);

        }

}

export default AlertLocation;

