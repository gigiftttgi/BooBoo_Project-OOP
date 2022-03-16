import { useEffect, useState } from 'react';
import axios from 'axios';
import iAntibobyA from './image/antibody/AntibodyA.png'
import iAntibobyB from './image/antibody/AntibodyB.png'
import iAntibobyC from './image/antibody/AntibodyC.png'

const Shop = ({ Antibody }) => {

  const [money, setMoney] = useState('');

  const fetchMoney = async () => {
    try {
      const m = await axios('/shop/money',);
      setMoney(m.data);
    } catch (err) {
      console.error(err.message);
    }
  };

  useEffect(async () => {
    fetchMoney()

    const interval = setInterval(() => {
      fetchMoney()
    }, 1000)
    return () => clearInterval(interval)


  }, []);



  function sentBuyAntiA() {

    if (money <= 30) {
      alert("You don't have enough money to buy it!!!");
    }

    Antibody('A');
  }

  function sentBuyAntiB() {

    if (money <= 50) {
      alert("You don't have enough money to buy it!!!");
    }
    Antibody('B');
  }

  function sentBuyAntiC() {

    if (money <= 80) {
      alert("You don't have enough money to buy it!!!");
    }
    Antibody('C');
  }




  return (

    <div className="Shop">
      <div className="Shoptext">SHOP</div>
      <div className="CreditBar">
        {money} Credit
      </div>

      <div className="AntiShop">

        <div className="AntiBox">
          <div className="AntiImgBox">
            <img className="AntiImgShop" src={iAntibobyA}></img>
          </div>
          <div className="AntiTextBox">
            <div className="AntiText">
              Antibody A <br /> <span className='inform'>HP : 100 | ATK : 15</span>
            </div>
            <button className='BuyBtn' onClick={() => { sentBuyAntiA() }
            } >30 Credit</button>
          </div>
        </div>

        <div className="AntiBox">
          <div className="AntiImgBox">
            <img className="AntiImgShop" src={iAntibobyB}></img>
          </div>
          <div className="AntiTextBox">
            <div className="AntiText">
              Antibody B <br /> <span className='inform'>HP : 110 | ATK : 10</span>
            </div>
            <button className='BuyBtn' onClick={() => {sentBuyAntiB()}} >50 Credit</button>
          </div>
        </div>

        <div className="AntiBox">
          <div className="AntiImgBox">
            <img className="AntiImgShop" src={iAntibobyC} ></img>
          </div>
          <div className="AntiTextBox">
            <div className="AntiText">
              Antibody C <br /> <span className='inform'>HP : 120 | ATK : 10</span>
            </div>
            <button className='BuyBtn' onClick={() => {sentBuyAntiB()}}  >80 Credit </button>
          </div>
        </div>

      </div>

    </div>


  );

}



export default Shop