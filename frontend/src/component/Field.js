import React, { useState, useEffect } from 'react';
import axios from 'axios';
import iAntibobyA from './image/antibody/AntibodyA.png'
import iAntibobyB from './image/antibody/AntibodyB.png'
import iAntibobyC from './image/antibody/AntibodyC.png'
import iVirusX from './image/virus/VirusX.png'
import iVirusY from './image/virus/VirusY.png'
import iVirusZ from './image/virus/VirusZ.png'

// const GET_AREA_URL = 'http://localhost:8080/game/field';


const Field = ({ PositionApp, SentPos }) => {

    let i = 1;
    var Char = [''];
    const [position,setPosition] = useState(null);
    const [oldPos,setoldPos] = useState(0);

    const SentPosCell = (pos) => {
        SentPos(pos);
    }

    const fetchAnti = async () => {
        try {
            await axios.get('/field/character')
                .then((res) => {

                    Char = res.data.map(datas => ({
                        x : datas.pos.x ,
                        y :  datas.pos.y,
                        id : ((datas.pos.x - 1) * 15) + datas.pos.y,
                        type : datas.type
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
        const controller = new AbortController();

    const interval = setInterval(() => {
     fetchAnti()
    }, 3000)
    return () => {
        clearInterval(interval)
        controller.abort();
    }
  }, []);

  const Cell = ({ id, SentPosCell }) => {

    let pos = id;
    let type = '';
  
    // var antiBuy = SentAntiF;

    const [imgSrc, setimgSrc] = useState('');
    const [show, setShow] = useState(0);
    
    function showID() {
        // setShow(0);
        var found = false;
        
        Char.forEach(host => {
          if(host.id === pos){
            type = host.type;
            chooseImgPath(type)
            found = true;
        }
      }); 
      
      if(found){
        setShow(1);
      }else{
          setShow(0);
      }
  }
  
    function chooseImgPath(type) {
      if (type === 'A') setimgSrc(iAntibobyA);
      else if (type === 'B') setimgSrc(iAntibobyB);
      else if (type === 'C') setimgSrc(iAntibobyC);
      else if (type === 'X') setimgSrc(iVirusX);
      else if (type === 'Y') setimgSrc(iVirusY);
      else if (type === 'Z') setimgSrc(iVirusZ);
    }
  
    useEffect(async () => {
      showID();
      const controller = new AbortController();
      const interval = setInterval(() => {
          showID()
      },3000)
      return () => {
          clearInterval(interval)
        controller.abort();}
  }, []);

  function ondrop(event){
      event.preventDefault();
      var dropCharfrom = event.dataTransfer.getData("oldpos")
      var newPos = pos;
      console.log("drop",dropCharfrom,"at",newPos)
      axios.post('/field/move', { "p": dropCharfrom , "q":newPos})
          .then(response => console.log(response.data));
  }

  function ondrag(event){
    console.log(pos, 'dragging')
  }

  function ondragstart(event){
    console.log("drag start" , pos);
    //setoldPos(pos)
    event.dataTransfer.setData("oldpos", pos);
  }

  function ondragover(event){
    //console.log(pos,"drag end");
    event.preventDefault();
  }
  

     if (show === 1) {
      console.log("id",pos,"show",show);
      return (
        <td className="Cell" onDragStart = {ondragstart} onDrag={ondrag} onDragOver={ondragover} >
              <div><img className = "AntiImgCell" src={imgSrc} /></div>
        </td>
      )
      
    }
    else {
      return (
        <td className="Cell" onClick={() => SentPos(pos)} onDragOver={ondragover} onDrop={ondrop} >
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
                    {Array.from({ length: 10 }, _ =>
                        <tr>{Array.from({ length: 15 }, _ =>

                            
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