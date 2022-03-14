// import React, { Component } from 'react';
// import MenuButton from './Menubutton';


const Menu = () => {

  // function sentPause(state) {
  //   axios.put('/gameState', anti)
  //     .then(response => console.log(response.data));

  // }


    return (
        <div className = "Menu">
             <button className='menuBtn' >
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