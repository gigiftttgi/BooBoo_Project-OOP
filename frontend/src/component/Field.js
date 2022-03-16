import React, { useState, useEffect } from 'react';
import Cell from './Cell';
import axios from 'axios';

let Char = [' '];

const Field = ({ PositionApp, SentAnti }) => {

    let i = 1;
    
    const Anti = SentAnti;
    const [visi,setVisi] = useState(['']);
    
    const fetchAnti = async () => {
        try {
            await axios.get('/field/character')
                .then((res) => {

                    Char = res.data.map(datas => ({
                        id: ((datas.pos.x - 1) * 25) + datas.pos.y,
                        type: datas.type
                    }
                    ));
                    // setVisi(Char);
                    // console.log(visi);
                    // console.log("char",Char)
                    // Char = ['']
                })
        } catch (err) {
            // console.error(err.message);
        }
    };

    useEffect(async () => {
        await fetchAnti()
        const interval = setInterval(() => {
            fetchAnti()
            setVisi(Char);

        }, 3000)
        return () => clearInterval(interval)
    }, []);


    

    return (
        <div className="Field">
            <table className="Table">
                <tbody>
                    {Array.from({ length: 17 }, _ =>
                        <tr>{Array.from({ length: 25 }, _ =>
                            // {console.log(visi)},
                            <Cell id={i++} SentAntiF={Anti} v={visi}>
                            </Cell>
                        )}
                        </tr>)}


                </tbody>
            </table>

        </div>


    );




}



export default Field;