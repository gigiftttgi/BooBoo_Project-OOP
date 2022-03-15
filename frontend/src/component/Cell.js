import { useState } from "react";
import ImgCell from "./ImgCell";

const Cell  = (id) => {

  let pos = id;

  const [data, setData] = useState('');

  function sentpos(pos){
    var x = pos.id%24;
    var y = pos.id- (25*((pos.id%24)-1));
    showImg();
    // document.innerHTML = "<img className='AntiImg' src={require('./image/antibody/AntibodyB.png')}/>";
    // var img = document.createElement('img')
    // img.src = './image/antibody/AntibodyB.png';
    // document.getElementById(id).appendChild(img);  
}

    function showImg(){
        const Img = () =>{
            setData("hi");
        }
    }


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
    <td className="Cell" onClick={()=>{sentpos(pos)}} >
        <ImgCell id={pos} Img={data} ></ImgCell>
    </td>

    )
  }

export default Cell