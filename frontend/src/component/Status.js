import { useEffect, useState } from 'react';
import axios from 'axios';
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";

const Status = () => {

    const [state, setState] = useState('');
    // const [type, setType] = useState('');

    const fetchStatus = async () => {
        try {
            const m = await axios('/gameover',);
            setState(m.data);
        } catch (err) {
            console.error(err.message);
        }
    };

    useEffect(async () => {
        await fetchStatus()
        const interval = setInterval(() => {
            fetchStatus()
        }, 10000)
        return () => clearInterval(interval)

    }, []);


    const render = (state) => {
        if (state === "You win" || state === "You lose") {
            return (
                // <button 
                // className='BuyBtn'
                // // onClick={() => {sentType("B") }} 
                // >Play Again</button>

                <Link to="/" className='BuyBtn' 
                // onClick={() => { startGame() }}
            >Play Again</Link>
            )

        }
        console.log(state);

    }




    return (

        <div className="Shop">
            <div className="Shoptext">{state}</div>
            {render(state)}
        </div>

    );

}



export default Status