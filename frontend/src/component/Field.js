import React, { useState } from 'react';
import APIService from './APIService';
import Cell from './Cell';

const Field = ({PositionApp,SentAnti}) => {

    let i = 1;

    // const [sell, setCell] = useState('');
    // const [Pos,setPos] = React.useState(null);
    
    // const Position = (pos) =>{
    //     // setPos(pos);
    //     PositionApp(pos);
        
    // }

    const Anti = SentAnti;
    // const SentAntiF = () => {
    //     SetAnti(SentAnti);
    //   }

    return (
        <div className="Field">

            <table className="Table">
                <tbody>
                    {Array.from({ length: 17 }, _ =>
                        <tr>{Array.from({ length: 25 }, _ =>
                            
                            <Cell id={i++} SentAntiF = {Anti}>
                            </Cell>
                            )} 
                            </tr>)}

                   
                </tbody>
            </table>

        </div>


    );




}



export default Field;