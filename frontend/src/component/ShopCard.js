import React, { Component } from 'react';

class ShopCard extends React.Component {
    render() {
        return (
            <div className="Card">
                {this.props.children}
            </div>
        );
    }


}


export default ShopCard;