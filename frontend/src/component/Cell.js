import { useState } from "react";
import ImgCell from "./ImgCell";

const Cell  = ({id,SentAntiF}) => {

  let pos = id;
  var y = pos.id%25;
    if(y==0) y=25;
    var x = ((pos.id - y) /25) +1;


   function sentpos(){
        console.log(SentAntiF);
    }

   
//     console.log(x,y)
//     showImg();
    // document.innerHTML = "<img className='AntiImg' src={require('./image/antibody/AntibodyB.png')}/>";
    // var img = document.createElement('img')
    // img.src = './image/antibody/AntibodyB.png';
    // document.getElementById(id).appendChild(img);  
// }

  // function sentposbuyB(pos){
  //   var x = pos.id%25;
  //   var y = pos.id%17;
  //   console.log(x,y);
  // }

  // function sentposbuyC(pos){
    // var x = pos.id%24;
    // var y = pos.id- (25*((pos.id%24)-1));
    // console.log(x,y);
  // }
  

  return (
    <td className="Cell" onClick={() => {sentpos()}} >
        {/* <ImgCell id={pos}  ></ImgCell> */}
    </td>

    )
  }

export default Cell