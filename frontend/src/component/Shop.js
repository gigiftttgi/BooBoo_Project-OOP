import { useEffect, useState } from 'react';
import axios from 'axios';


const Shop = ({Antibody}) => {

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
  
    if(money == 0){
      alert("BOO BOO");
    }

    Antibody('A');
  }

  function sentBuyAntiB() {
   
    if(money == 0){
      alert("BOO BOO");
    }
    Antibody('B');
  }

  function sentBuyAntiC() {
    
    if(money == 0){
      alert("BOO BOO");
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
            <img className="AntiImg" src={require('./image/antibody/AntibodyA.png')}></img>
          </div>
          <div className="AntiTextBox">
            <div className="AntiText">
              Antibody A <br /> <span className='inform'>HP : 100 | ATK : 15</span>
            </div>
            <button className='BuyBtn' onClick={() => {sentBuyAntiA()}
              } >30 Credit</button>
          </div>
        </div>

        <div className="AntiBox">
          <div className="AntiImgBox">
            <img className="AntiImg" src={require('./image/antibody/AntibodyB.png')}></img>
          </div>
          <div className="AntiTextBox">
            <div className="AntiText">
              Antibody B <br /> <span className='inform'>HP : 110 | ATK : 10</span>
            </div>
            <button className='BuyBtn' onClick={() => 
             {sentBuyAntiB()}

              } >50 Credit</button>
          </div>
        </div>

        <div className="AntiBox">
          <div className="AntiImgBox">
            <img className="AntiImg" src={require('./image/antibody/AntibodyC.png')} ></img>
          </div>
          <div className="AntiTextBox">
            <div className="AntiText">
              Antibody C <br /> <span className='inform'>HP : 120 | ATK : 10</span>
            </div>
            <button className='BuyBtn' onClick={() => 
              {sentBuyAntiC()} 
              }  >80 Credit </button>
          </div>
        </div>

      </div>

    </div>


  );

}



export default Shop