import { MapContainer, Marker, Popup, TileLayer, useMapEvent} from 'react-leaflet';
import L from 'leaflet';
import CocheSVG from './CocheSVG';
import { useEffect, useState } from 'react';
import { Client } from '@stomp/stompjs';

function EvtClickMapa({ onClick }){

  useMapEvent({
    click(e) {
      onClick(e.latlng)
    }
  })

}





export default function App() {

  const position = [6.25184, -75.56359];

  const [posicionCoche, setPosicionCoche] = useState([0,0])

  useEffect (()=> {
    const cliente = new Client({
      brokerURL: 'ws://localhost:8080/websocket' 
    
    })
    cliente.onConnect = () => {
      console.log('Conectado')
      cliente.subscribe('/taxi/coordenada' , (m) => {  
        const coordenada = JSON.parse(m.body)
        const puntoNuevo = [coordenada.x, coordenada.y]
        setPosicionCoche(puntoNuevo)
      })
    }


cliente.activate()
return () => {
  if (cliente.activate) {
    cliente.deactivate()
  }
}
}, [])



  const svgIconCoche = L.divIcon({
    html: `<div class = "svg-icon"><${CocheSVG}/></div>
    `,
    className: 'svg-icon',
   })


return (
  <MapContainer center={position} zoom={13} scrollWheelZoom={true}>
    <TileLayer
      attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
      url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
    />

   <EvtClickMapa onClick={(c) => console.log(c)}/>

    <Marker position={posicionCoche} icon={svgIconCoche}/> 
  </MapContainer>);
}
