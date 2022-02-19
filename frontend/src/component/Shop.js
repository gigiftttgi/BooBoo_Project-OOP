

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