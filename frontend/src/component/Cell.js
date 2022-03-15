import { useState } from "react";
import ImgCell from "./ImgCell";
import axios from 'axios';

const Cell = ({ id, SentAntiF }) => {

  const pos = id;
  var y = pos.id % 25;
  if (y == 0) y = 25;
  var x = ((pos.id - y) / 25) + 1;

  const [anti, setAnti] = useState('');




  //   const fetchAnti = async () => {
  //     try {
  //       const m = await axios('/shop/getAnti',);
  //       setAnti(m.data);
  //       console.log(m.data);
  //     } catch (err) {
  //       console.error(err.message);
  //     }
  //   };


  // useEffect(async () => {
  //   fetchAnti()

  //   const interval = setInterval(() => {
  //     fetchAnti()
  //   }, 1000)
  //   return () => clearInterval(interval)


  // }, []);



  function sentpos() {
    console.log(SentAntiF);
  }


  function setBuyreq() {
    if (SentAntiF === "A") {
      
      console.log("It's A", pos);

      axios.post('/shop/buyA', pos)
        .then(response => console.log(response.data));

    } else if (SentAntiF === "B") {
      console.log("It's B",pos);
      axios.post('/shop/buyB', pos)
        .then(response => console.log(response.data));
    } else if (SentAntiF === "C") {
      console.log("It's C",pos);
      axios.post('/shop/buyC', pos)
        .then(response => console.log(response.data));
    }
  }

   
//     console.log(x,y)
//     showImg();
    // document.innerHTML = "<img className='AntiImg' src={require('./image/antibody/AntibodyB.png')}/>";
    // var img = document.createElement('img')
    // img.src = './image/antibody/AntibodyB.png';
    // document.getElementById(id).appendChild(img);  
// }




  // function sentposA(pos){
  //   var x = pos.id%24;
  //   var y = pos.id- (25*((pos.id%24)-1));
  //   console.log(x,y);
  // }
  // function sentposB(pos){
  //   var x = pos.id%24;
  //   var y = pos.id- (25*((pos.id%24)-1));
  //   console.log(x,y);
  // }
  // function sentposC(pos){
  //   var x = pos.id%24;
  //   var y = pos.id- (25*((pos.id%24)-1));
  //   console.log(x,y);
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
    <td className="Cell" onClick={() => { setBuyreq() }} >
      {/* <ImgCell id={pos}  ></ImgCell> */}
    </td>

  )
}

export default Cell