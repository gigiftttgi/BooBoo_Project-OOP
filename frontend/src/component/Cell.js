const Cell  = (id) => {

  let pos = id;


  function sentpos(pos){
    var x = pos.id%24;
    var y = pos.id- (25*((pos.id%24)-1));
    console.log(x,y);
  }

  // function sentposbuyB(pos){
  //   var x = pos.id%25;
  //   var y = pos.id%17;
  //   console.log(x,y);
  // }

  // function sentposbuyC(pos){
    // var x = pos.id%24;
    // var y = pos.id- (25*((pos.id%24)-1));
    // console.log(x,y);
  // }
  

  return (
    <td className="Cell" 
    onClick={()=>{sentpos(pos)}} 
    >
      

    
      {/* {id} */}


    </td>

    )
  }

export default Cell