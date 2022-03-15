import { useEffect, useState } from 'react';
import axios from 'axios';

const Shop = () => {

  const [money, setMoney] = useState('');


  const fetchMoney = async () => {
    try {
      const m = await axios('/shop/money',);
      setMoney(m.data);
      console.log(m.data);
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


  function sentBuyAntiA(anti) {
    axios.post('/shop/buyA', anti)
      .then(response => console.log(response.data));

  }

  function sentBuyAntiB(anti) {
    axios.post('/shop/buyB', anti)
      .then(response => console.log(response.data));

  }

  function sentBuyAntiC(anti) {
    axios.post('/shop/buyC', anti)
      .then(response => console.log(response.data));

  }



  return (

    <div className = "Shop">
      <div className="Shoptext">SHOP</div>
      <div className= "CreditBar">
        {money} Credit
      </div>

      <div className = "AntiShop">

        <div className = "AntiBox">
          <div className = "AntiImgBox">
            <img className="AntiImg" src={require('./image/antibody/AntibodyA.png')}></img>
          </div>
          <div className = "AntiTextBox">
            <div className = "AntiText">
              Antibody A <br/> HI
            </div>
            <button className='BuyBtn' onClick={() => { sentBuyAntiA("antiA"); }} >20 Credit</button>
          </div>
        </div>

        <div className = "AntiBox">
          <div className = "AntiImgBox">
            <img className="AntiImg" src={require('./image/antibody/AntibodyB.png')}></img>
          </div>
          <div className = "AntiTextBox">
            <div className = "AntiText">
              Antibody B <br/> HI
            </div>
            <button className='BuyBtn' onClick={() => { sentBuyAntiB("antiB"); }} >30 Credit</button>
          </div>
        </div>

        <div className = "AntiBox">
          <div className = "AntiImgBox">
            <img className="AntiImg" src={require('./image/antibody/AntibodyC.png')} ></img>
          </div>
          <div className = "AntiTextBox">
            <div className = "AntiText">
              Antibody C <br/> HI
            </div>
            <button className='BuyBtn' onClick={() => { sentBuyAntiC("antiC"); }} >40 Credit</button>
          </div>
          </div>

      </div>
      
    </div>


  );

}


export default Shop;