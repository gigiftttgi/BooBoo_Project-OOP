import React from 'react';
import APIService from './APIService';
import Cell from './Cell';

const Field  = () => {


   return(
       <div className="Field">
            
            <table className = "Table">
               
                    {Array.from({length:17}, _ =>
                        <tr>{Array.from({length:25}, _ => <td className = "Cell" ></td> )}</tr>
                    )}
                
            </table>
            
       </div>
       

   );

    


}



export default Field;