import React, { useState, useEffect } from 'react';
import APIService from './APIService';
import Cell from './Cell';
import axios from 'axios';
var Char = [''];

const Field = ({ PositionApp, SentAnti }) => {

    let i = 1;
    
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

            showID();
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

    const [anti, setAnti] = useState('');
    const [imgSrc, setimgSrc] = useState('');
    const [type, setType] = useState('');


    const Anti = SentAnti;

    const [hostId, sethostId] = useState(0);
    const [show, setShow] = useState(0);


    function showID() {

        Char.forEach(host => {
    
          console.log("host", host.id);

          sethostId(host.id);
          let t = host.type;
          setType(t);
          setShow(1);
    
      
        });
    }

    return (
        <div className="Field">

            <table className="Table">
                <tbody>
                    {Array.from({ length: 17 }, _ =>
                        <tr>{Array.from({ length: 25 }, _ =>

                            
                            <Cell id={i++} SentAntiF={Anti} Img={type} hostId={hostId}><p>1</p>
                            </Cell>
                        )}
                        </tr>)}


                </tbody>
            </table>

        </div>


    );




}



export default Field;