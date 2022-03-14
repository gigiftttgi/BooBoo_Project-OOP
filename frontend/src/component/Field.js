import React from 'react';
import APIService from './APIService';
import Cell from './Cell';

const Field  = () => {


   return(
       <div className="Field">
            {/* <div className = "Cell">
           

           </div> */}
           {/* <script>
               var max = 10;
           document.write("<table className = "Table">");

                document.write("<tr>");

                for(var j = 1; j < max; j++){
                    document.write("<tr className = 'Cell' > </td>");
                }       

                document.write("</tr>"); 
            
           document.write("</table>");

           </script> */}
            
            <table className = "Table">
               
                    {Array.from({length:17}, _ =>
                        <tr>{Array.from({length:25}, _ => <td className = "Cell" ></td> )}</tr>
                    )}
                
            </table>
       </div>
       

   );

    


}



export default Field;