import { useState } from "react";
import ImgCell from "./ImgCell";

const Cell  = ({id,SentAntiF}) => {

  let pos = id;
  var y = pos.id%25;
    if(y==0) y=25;
    var x = ((pos.id - y) /25) +1;

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


//   function sentpos(pos) {
//     var y = pos.id % 25;
//     if (y == 0) y = 25;
//     var x = ((pos.id - y) / 25) + 1;
//     console.log(x, y);

//     fetchAnti();
//     console.log(anti === "antiA");


//     if (anti === "antiA") {
//       console.log("A");

//     } else if (anti === "antiB") {
//       console.log("B");
//     } else if (anti == "antiC") {
//       console.log("C");
//     } else {

//     }
// }



   function sentpos(){
        console.log(SentAntiF);
    }




  return (
    <td className="Cell" onClick={() => {sentpos()}} >
        {/* <ImgCell id={pos}  ></ImgCell> */}
    </td>

  )
}

export default Cell