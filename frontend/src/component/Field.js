import React, { useState } from 'react';
import APIService from './APIService';
import Cell from './Cell';

const Field = () => {

    let i = 1;

    const [sell, setCell] = useState('');


    return (
        <div className="Field">

            <table className="Table">
                <tbody>
                    {Array.from({ length: 17 }, _ =>
                        <tr>{Array.from({ length: 25 }, _ =>
                            
                            <Cell id={i++}>
                            </Cell>
                            )} 
                            </tr>)}

                   
                </tbody>
            </table>

        </div>


    );




}



export default Field;