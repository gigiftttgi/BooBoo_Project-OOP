// import { useState, useEffect } from "react";
// import ImgCell from "./ImgCell";
// import axios from 'axios';
// import iAntibobyA from './image/antibody/AntibodyA.png'
// import iAntibobyB from './image/antibody/AntibodyB.png'
// import iAntibobyC from './image/antibody/AntibodyC.png'
// import iVirusX from './image/antibody/AntibodyA.png'
// import iVirusY from './image/antibody/AntibodyB.png'
// import iVirusZ from './image/antibody/AntibodyC.png'


// const Cell = ({ id, SentAntiF, allChar}) => {

//   let pos = id;
//   let type = '';

//   var allC = allChar;
//   var antiBuy = SentAntiF;
// //   const type = Img;
//   const [imgSrc, setimgSrc] = useState('');
//   const [show, setShow] = useState(0);
  
//   function showID() {
//       console.log("all",allChar)
//     allChar.forEach(host => {

//         if(host.id == pos.id && host.id !== undefined){
         
//           type = host.type;
//           setShow(1);
//       }
  
//     }); 
    
// }

//   function setBuyreq() {

//     if (antiBuy != null) {
//       if (antiBuy === "A") {
//         console.log("It's A", pos);
//         axios.post('/shop/buyA', { "p": pos })
//           .then(response => console.log(response.data));
//       } else if (antiBuy === "B") {
//         console.log("It's B", pos);
//         axios.post('/shop/buyB', { "p": pos })
//           .then(response => console.log(response.data));
//       } else if (antiBuy === "C") {
//         console.log("It's C", pos);
//         axios.post('/shop/buyC', { "p": pos })
//           .then(response => console.log(response.data));
//       }
//     }
//     antiBuy = null;
//     // fetchAnti();
//   }


//   function chooseImgPath(type) {
//     console.log("Image");
//     if (type === 'A') setimgSrc('./image/antibody/AntibodyA.png');
//     else if (type === 'B') return iAntibobyB;
//     else if (type === 'C') return iAntibobyC;
//     else if (type === 'X') return iVirusX;
//     else if (type === 'Y') return iVirusY;
//     else if (type === 'Z') return iVirusZ;
//   }

//   useEffect(async () => {
//     showID();
//     const interval = setInterval(() => {
//         showID()
//     },3000)
//     return () => clearInterval(interval)
// }, []);


// //   console.log("hId", hId,"pos", pos);

//     // showID();
//   if (show === 1) {
//    console.log(pos,show);
//     return (
//       <td className="Cell" >
//             {/* <img src={imgSrc} /> */}
//             1
//       </td>
//     )
    
//   }
//   else {
//     return (
//       <td className="Cell" onClick={() => { setBuyreq() }} >
//         {/* <ImgCell id={pos}  ></ImgCell> */} 
//       </td>

//     )
//   }
// }

// export default Cell