import { useState } from "react";
import ImgCell from "./ImgCell";
import axios from 'axios';

const Cell = ({ id, SentAntiF }) => {

  const pos = id;
  var y = pos.id % 25;
  if (y == 0) y = 25;
  var x = ((pos.id - y) / 25) + 1;

  const [anti, setAnti] = useState('');


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




  return (
    <td className="Cell" onClick={() => { setBuyreq() }} >
      {/* <ImgCell id={pos}  ></ImgCell> */}
    </td>

  )
}

export default Cell