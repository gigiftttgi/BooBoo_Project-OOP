import { useState, useEffect } from "react";
import ImgCell from "./ImgCell";
import axios from 'axios';
import iAntibobyA from './image/antibody/AntibodyA.png'
import iAntibobyB from './image/antibody/AntibodyB.png'
import iAntibobyC from './image/antibody/AntibodyC.png'
import iVirusX from './image/antibody/AntibodyA.png'
import iVirusY from './image/antibody/AntibodyB.png'
import iVirusZ from './image/antibody/AntibodyC.png'


var Char = [''];



const Cell = ({ id, SentAntiF, Img, hostId }) => {

  const pos = id;
  const type = Img;
  const [imgSrc, setimgSrc] = useState('');
  // const [show, setShow] = useState(0);

  const hId = hostId;

  // console.log(document.getElementById('td').innerText)
  // if(document.getElementById('td').innerText === '1'){
  //   console.log(document.getElementById('td').innerText)
  // }

  function sentpos() {
    console.log(SentAntiF);
  }


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
    // fetchAnti();


  }


  function chooseImgPath(type) {
    console.log("Image");
    if (type === 'A') setimgSrc('./image/antibody/AntibodyA.png');
    else if (type === 'B') return iAntibobyB;
    else if (type === 'C') return iAntibobyC;
    else if (type === 'X') return iVirusX;
    else if (type === 'Y') return iVirusY;
    else if (type === 'Z') return iVirusZ;

  }

  const [oldpos, setoldpos] = useState(0);
  // if(o === 1){
  //   setoldpos(1);
  // }


  console.log(oldpos,"hId", hId,"pos", pos);
  // console.log("hId", hId);
  // console.log("pos", pos);
  
  if (hId === pos || oldpos === 1) {
    setoldpos(1);
    console.log("HI")
    // setimgSrc(chooseImgPath(type));
    // chooseImgPath(type);
    // console.log(type);
    // console.log(imgSrc);
    return (
      <td className="Cell"  id='td' >
        {/* {chooseImgPath(type)} */}
        {/* <ImgCell id={pos}  ></ImgCell> */}
        {/* <img src={imgSrc} /> */}
        1
      </td>

    )
    // document
  }
  else {
    // console.log(hId)
    return (
      <td className="Cell" id='td' onClick={() => { setBuyreq() }} >
        {/* <ImgCell id={pos}  ></ImgCell> */}
      </td>

    )
  }

  return (
    <td className="Cell" id='td' onClick={() => { setBuyreq() }} >
      <ImgCell id={pos}  ></ImgCell>
    </td>

  )
}

export default Cell