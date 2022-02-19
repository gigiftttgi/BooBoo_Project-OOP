
import React, { Component } from 'react';
import ShopCard from './ShopCard';


=======
import React from 'react';
class Shop extends React.Component {
    render() {
      return (
        <div className="Shop">
          I am Shop
          <div className="CreditBar">  <p className="CreditText">Credit + Money</p> </div>
          <div className="grid-container">
            <div className="Card1">

              <div className="Lable">
                <h2>Antibody C</h2>
              </div>
              
              <img src="frontend/src/image/antibody/antiC.png" alt="antiC shop" class="center"></img>

              <button className="btnC"> BUY </button>

            </div>

            <div className="Card2">

              <div className="Lable">
                <h2>Antibody B</h2>
              </div>

              <img src="frontend/src/image/antibody/antiB.png" alt="antiB shop" class="center"></img>

              <button className="btnC"> BUY </button>

            </div>
            
            <div className="Card3">

              <div className="Lable">
                <h2>Antibody A</h2>
              </div>

              <img src="frontend/src/image/antibody/antiA.png" alt="antiA shop" class="center"></img>

              <button className="btnC"> BUY </button>

            </div>
          </div>


const Shop = () => {

  return (
    <div className='Shop'>
      <div className='CreditBar'>
        <p className="CreditText">Credit + Money</p>
      </div>

      <div className="px-100">
        <div className='Card'>
          <div className='Name'>
            Antibody A
          </div>
          <img src={require('./image/antibody/antiA.png')} className="antiImg"></img>
          <button className='BuyBtn'>Buy</button>
        </div>
        <div className='Card'>
          <div className='Name'>
            Antibody B
          </div>
          <img src={require('./image/antibody/antiB.png')} className="antiImg"></img>
          <button className='BuyBtn'>Buy</button>
        </div>
        <div className='Card'>
          <div className='Name'>
            Antibody C
          </div>
          <img src={require('./image/antibody/antiC.png')} className="antiImg"></img>
          <button className='BuyBtn'>Buy</button>
        </div>
      </div>



    </div>







  );



}


export default Shop;