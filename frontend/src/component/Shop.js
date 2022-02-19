import React, { Component } from 'react';
import ShopCard from './ShopCard';

class Shop extends React.Component {
    render() {
      return (
        <div className="Shop">
          I am Shop
          <div className="CreditBar">
            <p className="CreditText">Credit + Money</p>
          </div>

          <ShopCard>
            <img src="frontend/src/image/antibody/antiA.png" alt="antiA shop" ></img>
            
          </ShopCard>
          <ShopCard>
            <img src="frontend/src/image/antibody/antiB.png" alt="antiB shop"></img>
          </ShopCard>
          <ShopCard>
            <img src="frontend/src/image/antibody/antiC.png" alt="antiC shop"></img>
          </ShopCard>


        </div>
      );
    }


}


export default Shop;