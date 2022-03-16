// import React, { Component } from 'react';
// import MenuButton from './Menubutton';

import axios from 'axios';
import { useState } from 'react';


const Menu = () => {

  const[count, setCount] = useState(0);

  // function sentPause() {
  //   axios.post('/pause', "pause")
  //     .then(response => console.log(response.data));

  // }

  function sentPR(){
    if(count==0){
      axios.post('/pause', "pause")
      .then(response => console.log(response.data));
      setCount(1);
    }else{
      axios.post('/resume', "resume")
      .then(response => console.log(response.data));
      setCount(0);

    }
  }


    return (
        <div className = "Menu">
             <button className='menuBtn'  onClick={() => {sentPR()}}>
              <img className='imgMenu' src={require('./image/button/pause button.png')}></img>
            </button>

            <button className='menuBtn'>
              <img className='imgMenu' src={require('./image/button/speed down.png')}></img>
            </button>

            <button className='menuBtn'>
              <img className='imgMenu' src={require('./image/button/speed up.png')}></img>
            </button>

            <button className='menuBtn'>
              <img className='imgMenu' src={require('./image/button/zoom in.png')}></img>
            </button>

            <button className='menuBtn'>
              <img className='imgMenu' src={require('./image/button/zoom out.png')}></img>
            </button>
        </div>
    );
}


export default Menu;