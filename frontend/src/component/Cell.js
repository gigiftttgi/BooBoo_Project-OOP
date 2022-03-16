import { useState, useEffect } from "react";
import ImgCell from "./ImgCell";
import axios from 'axios';
import iAntibobyA from './image/antibody/AntibodyA.png'
import iAntibobyB from './image/antibody/AntibodyB.png'
import iAntibobyC from './image/antibody/AntibodyC.png'
import iVirusX from './image/antibody/AntibodyA.png'
import iVirusY from './image/antibody/AntibodyB.png'
import iVirusZ from './image/antibody/AntibodyC.png'


const Cell = ({ id, SentAntiF, v }) => {
  const pos = id;
  let [type, setType] = useState('');
  const [imgSrc, setimgSrc] = useState('');
  let [show, setShow] = useState(0);
  const visible = v;

  // function sentpos() {
  //   console.log(SentAntiF);
  // }


  function setBuyreq() {
    if (SentAntiF != null) {
      if (SentAntiF === "A") {
        console.log("It's A", pos);
        axios.post('/shop/buyA', { "p": pos })
          .then(response => console.log(response.data));
      } else if (SentAntiF === "B") {
        console.log("It's B", pos);
        axios.post('/shop/buyB', { "p": pos })
          .then(response => console.log(response.data));
      } else if (SentAntiF === "C") {
        console.log("It's C", pos);
        axios.post('/shop/buyC', { "p": pos })
          .then(response => console.log(response.data));
      }
    }
    SentAntiF = null;
    
  }

  function showID() {
    console.log(visible)
    visible.forEach(host => {
      // console.log("host", host.id, "pos" , pos)
      if (host.id === pos) {
        setType(host.type);
        setimgSrc(chooseImgPath(host.type))
        setShow(1);
      }
    });
  }


  function chooseImgPath(type) {
    console.log(type);
    if (type === 'A') return './image/antibody/AntibodyA.png';
    else if (type === 'B') return './image/antibody/AntibodyB.png';
    else if (type === 'C') return './image/antibody/AntibodyC.png';
    else if (type === 'X') return iVirusX;
    else if (type === 'Y') return iVirusY;
    else if (type === 'Z') return iVirusZ;

  }

  useEffect(async () => {
    await showID()
    const interval = setInterval(() => {
      showID()
    }, 3000)
    return () => clearInterval(interval)
  }, []);


  const render = () => {
    console.log("render", show)
    if (show === 1) {
      // setimgSrc(chooseImgPath(type))
      console.log(imgSrc);
      return (
        // <td className="Cell" id='td' >
          <img src={imgSrc}/>
        // </td>
        // <img src={require({imgSrc})}/>
      )
    } else {
      // return (
      //   // <td className="Cell" id='td' onClick={() => { setBuyreq() }} >
      //   //   {/* <ImgCell id={pos}  ></ImgCell> */}
      //   // </td>
      // )
    }
  }


  return (

    <td className="Cell" onClick={() => { setBuyreq() }} >
      {render()}  
    </td>
  )
}

export default Cell