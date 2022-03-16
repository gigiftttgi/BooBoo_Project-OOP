// import React, { useState, useEffect } from 'react';

// import APIService from './APIService';
// import Cell from './Cell';
// import axios from 'axios';

// const Field = ({ PositionApp, SentAnti }) => {

//     let i = 1;
//     var Char = [''];
//     // console.log(document.getElementById('td').innerText)

//     const fetchAnti = async () => {
//         try {
//             await axios.get('/field/character')
//                 .then((res) => {

//                     Char = res.data.map(datas => ({
//                         id: ((datas.pos.x - 1) * 25) + datas.pos.y,
//                         type: datas.type
//                     }
//                     ));
//                     console.log(Char)
//                 })
//             // console.log(antiField);
//         } catch (err) {
//             // console.error(err.message);
//         }
//     };
   
//     // const type = '';

//     useEffect(async () => {
//     fetchAnti();
   

//     const interval = setInterval(() => {
//       fetchAnti()
//     }, 3000)
//     return () => clearInterval(interval)


//   }, []);


//     return (
//         <div className="Field">

//             <table className="Table">
//                 <tbody>
//                     {Array.from({ length: 17 }, _ =>
//                         <tr>{Array.from({ length: 25 }, _ =>

                            
//                             <Cell id={i++} SentAntiF={SentAnti} allChar={Char} ><p>1</p>
//                             </Cell>
//                         )}
//                         </tr>)}


//                 </tbody>
//             </table>

//         </div>


//     );
// }



// export default Field;

import React, { useState, useEffect } from 'react';
import APIService from './APIService';
import Cell from './Cell';
import axios from 'axios';
import iAntibobyA from './Image/AntibodyA.png'
import iAntibobyB from './Image/AntibodyB.png'
import iAntibobyC from './Image/AntibodyC.png'
import iVirusX from './Image/AntibodyA.png'
import iVirusY from './Image/AntibodyA.png'
import iVirusZ from './Image/AntibodyA.png'


const Field = ({ PositionApp, SentAnti }) => {

    let i = 1;
    var Char = [''];
    // console.log(document.getElementById('td').innerText)

    const fetchAnti = async () => {
        try {
            await axios.get('/field/character')
                .then((res) => {

                    Char = res.data.map(datas => ({
                        id: ((datas.pos.x - 1) * 25) + datas.pos.y,
                        type: datas.type
                    }
                    ));
                    console.log(Char)
                })
            // console.log(antiField);
        } catch (err) {
            // console.error(err.message);
        }
    };
   
    // const type = '';

    useEffect(async () => {
    fetchAnti();
   

    const interval = setInterval(() => {
      fetchAnti()
    }, 3000)
    return () => clearInterval(interval)


  }, []);

  const Cell = ({ id, SentAntiF }) => {

    let pos = id;
    let type = '';
  
    // var antiBuy = SentAntiF;

    const [imgSrc, setimgSrc] = useState('');
    const [show, setShow] = useState(0);
    
    function showID() {
        setShow(0);
        Char.forEach(host => {
            // console.log(host.id,pos)
          if(host.id === pos && host.id !== undefined){
           console.log("pass")
            type = host.type;
            chooseImgPath(type)
            setShow(1);
        }
    
      }); 
      
  }
  
    function setBuyreq() {
  
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
      
      //showinCell()
    }
  
  
    function chooseImgPath(type) {
      console.log("Image");
      if (type === 'A') setimgSrc(iAntibobyA);
      else if (type === 'B') setimgSrc(iAntibobyB);
      else if (type === 'C') setimgSrc(iAntibobyC);
      else if (type === 'X') return iVirusX;
      else if (type === 'Y') return iVirusY;
      else if (type === 'Z') return iVirusZ;
    }
  
    useEffect(async () => {
      showID();
      //showinCell()
      const interval = setInterval(() => {
          showID()
      },3000)
      return () => clearInterval(interval)
  }, []);
  
  
  //   console.log("hId", hId,"pos", pos);
  
      // showID();
    if (show === 1) {
     console.log(pos,show);
      return (
        <td className="Cell" >
              <img className = "AntiImgCell" src={require('./image/antibody/AntibodyA.png')} />
        </td>
      )
      
    }
    else {
      return (
        <td className="Cell" onClick={() => { setBuyreq() }} >
          {/* <ImgCell id={pos}  ></ImgCell> */} 
        </td>
  
      )
    }

  }

    return (
        <div className="Field">

            <table className="Table">
                <tbody>
                    {Array.from({ length: 17 }, _ =>
                        <tr>{Array.from({ length: 25 }, _ =>

                            
                            <Cell id={i++} SentAntiF={SentAnti} >
                            </Cell>
                        )}
                        </tr>)}


                </tbody>
            </table>

        </div>


    );
}



export default Field;