import React, { useState, useEffect } from 'react';
import Cell from './Cell';
import axios from 'axios';
import iAntibobyA from './image/antibody/AntibodyA.png'
import iAntibobyB from './image/antibody/AntibodyB.png'
import iAntibobyC from './image/antibody/AntibodyC.png'
import iVirusX from './image/antibody/AntibodyA.png'
import iVirusY from './image/antibody/AntibodyA.png'
import iVirusZ from './image/antibody/AntibodyA.png'


const Field = ({ PositionApp, SentPos }) => {

    let i = 1;
    var Char = [''];
    const [position,setPosition] = useState(null);

    const SentPosCell = (pos) => {
        SentPos(pos);
    }

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

    useEffect(async () => {
        await fetchAnti();
   

    const interval = setInterval(() => {
     fetchAnti()
    }, 3000)
    return () => clearInterval(interval)


  }, []);

  const Cell = ({ id, SentPosCell }) => {

    let pos = id;
    let type = '';
  
    // var antiBuy = SentAntiF;

    const [imgSrc, setimgSrc] = useState('');
    const [show, setShow] = useState(0);
    
    function showID() {
        // setShow(0);
        Char.forEach(host => {
            // console.log(host.id,pos)
          if(host.id === pos){
            type = host.type;
            chooseImgPath(type)
            setShow(1);
            
        }
      }); 
      
  }
  
    function chooseImgPath(type) {
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
  
//   console.log("anti",SentAntiF);
    if (show === 1) {
    console.log(pos,show);
      return (
        <td className="Cell" >
              <img className = "AntiImgCell" src={imgSrc} />
        </td>
      )
      
    }
    else {
        console.log("pass else")
      return (
        <td className="Cell" onClick={() => { getPos() }} >
          {/* <ImgCell id={pos}  ></ImgCell> */} 
        </td>
  
      )
    }

    function getPos() {
        SentPosCell(pos);
    }
  
  

  }
  

    return (
        <div className="Field">
            <table className="Table">
                <tbody>
                    {Array.from({ length: 17 }, _ =>
                        <tr>{Array.from({ length: 25 }, _ =>

                            
                            <Cell id={i++} SentPosCell={SentPosCell} >
                            </Cell>
                        )}
                        </tr>)}


                </tbody>
            </table>

        </div>


    );
}



export default Field;