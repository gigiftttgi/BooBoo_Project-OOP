import { useState } from 'react'

const ImgCell = (id,{Img}) => {
    
    
    return(
        <div>
            {/* <img className='AntiImg' src={require('./image/antibody/AntibodyB.png')}/> */}
            {Img}
        </div>
    )
} 

export default ImgCell