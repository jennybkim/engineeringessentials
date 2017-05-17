import React from 'react';
import 'react-datepicker/dist/react-datepicker.css';
import StockTicker from './StockTicker.js';
import Date from './Date.js';

class Input extends React.Component {
  constructor(props) {
    super(props);
    this.state = {StockTicker: '', start: '', end: ''};
    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleStockTickerChange = this.handleStockTickerChange.bind(this);
    this.handleStartChange = this.handleStartChange.bind(this);
    this.handleEndChange = this.handleEndChange.bind(this);
  }

  handleStockTickerChange(value) {
    this.setState({StockTicker: value});
  }

  handleStartChange(value) {
    this.setState({start: value});
  }

  handleSubmit(event) {
    event.preventDefault();
    this.props.onSubmit(this.state.StockTicker, this.state.Start, this.state.End);
  }

  handleStartChange(value) {
    this.setState({start: value});
  }

  handleEndChange(value) {
    this.setState({end: value});
  }

  render() {
    return (
      <form className='input-form'>
        <h3>Input Stock Information</h3>
        <StockTicker/>
        <Date name='start' label = "Start Date: " value={this.state.start} onChange={this.handleStartChange}/>
        <Date name='end' label = "End Date: " value={this.state.end} onChange={this.handleEndChange}/>  
        <button className='btn btn-primary' onClick={this.handleSubmit}>Submit</button>
      </form>
    );
  }
}

export default Input;