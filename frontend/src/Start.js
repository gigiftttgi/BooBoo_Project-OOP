import { useEffect, useState } from 'react'; 
import './Start.css';
import {BrowserRouter as Router,Routes, Route,Link} from "react-router-dom";

function Start(){
    return (
        
        <div className='bg'>
            <div className='Head'>
                <div className='name'>
                    CAREN
                </div> 
            </div>
            <div className='block'>
                <div className='Rule'>
                    <div className='txt'>
                        How to play
                    </div>          
                    
                        <div className='txt-1'>1. In order to win, you have to destroy all virus in the field</div>
                        <div className='txt-2'>2. Buy antibodies in the shop to place antibodies in the field</div>
                        <div className='txt-3'>3. Game over when all antibodies disappear</div>
                    
                    
                </div>
                
            </div>
            
            <div className='BTN'>
                <Link to = "/gameplay" className='play-btn'>play</Link>
            </div> 
        </div>
        
    );
}

export default Start;