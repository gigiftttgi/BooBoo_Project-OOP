// import React, { Component } from 'react';
// import MenuButton from './Menubutton';


const Menu = () => {
    return (
        <div className="Menu">
             <button className='menuBtn'>
            </button>
            <button className='menuBtn'>
                {/* <div className="pauseBtn"></div> */}
              {/* <img className='menuBtn' src={require('./Buttonimage/speedDownBtn.png')}></img> */}
            </button>
            <button className='menuBtn'>
              {/* <img className='menuBtn' src={require('./Buttonimage/speedUpBtn.png')}></img> */}
            </button>
            <button className='menuBtn'>
              {/* <img className='menuBtn' src={require('./Buttonimage/zoomInBtn.png')}></img> */}
            </button>
            <button className='menuBtn'>
              {/* <img className='menuBtn' src={require('./Buttonimage/ZoomOutBtn.png')}></img> */}
            </button>
        </div>
    );
}


export default Menu;