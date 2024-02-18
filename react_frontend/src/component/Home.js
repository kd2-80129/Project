import React from 'react'
import ScrollingBanner from './ScrollingBanner'
import Cards from './Cards'
import { Typography } from '@mui/material';
import AddLocationIcon from '@mui/icons-material/AddLocation';
import WineBarIcon from '@mui/icons-material/WineBar';
import RamenDiningIcon from '@mui/icons-material/RamenDining';
import PickOption from './PickOption';
const cardDetails = [
  {
    name: 'Card1',
    image: "https://images.unsplash.com/photo-1679678690998-88c8711cbe5f?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDF8MHxzZWFyY2h8OHx8aG90ZWx8ZW58MHwwfDB8fHww",
    description: "This is description"
  },
  {
    name: 'Card2',
    image: "https://plus.unsplash.com/premium_photo-1675745329378-5573c360f69f?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MjF8fGhvdGVsfGVufDB8MHwwfHx8MA%3D%3D", description: "This is description"
  },
  {
    name: 'Card3',
    image: "https://images.unsplash.com/photo-1578683010236-d716f9a3f461?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MjZ8fGhvdGVsfGVufDB8MHwwfHx8MA%3D%3D", description: "This is description"
  },
  {
    name: 'Card2',
    image: "https://plus.unsplash.com/premium_photo-1675745329378-5573c360f69f?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MjF8fGhvdGVsfGVufDB8MHwwfHx8MA%3D%3D", description: "This is description"
  },
  {
    name: 'Card3',
    image: "https://images.unsplash.com/photo-1578683010236-d716f9a3f461?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MjZ8fGhvdGVsfGVufDB8MHwwfHx8MA%3D%3D", description: "This is description"
  },
  {
    name: 'Card2',
    image: "https://plus.unsplash.com/premium_photo-1675745329378-5573c360f69f?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MjF8fGhvdGVsfGVufDB8MHwwfHx8MA%3D%3D", description: "This is description"
  },

];
const pickOption = [
  {
    name: 'Near Me',
    image: <AddLocationIcon />,

  },
  {
    name: 'Bar/Pub',
    image: <WineBarIcon />
  },
  {
    name: 'Dinner',
    image: <RamenDiningIcon />
  }
];

const Home = () => {
  return (
    <div>
      <ScrollingBanner />
      <div style={{ display: 'flex', width: "98vw", padding: "50px", flexWrap: 'wrap' }}>
        {cardDetails.map((obj, index) => (
          <Cards key={index} data={obj} />
        ))}
      </div>
      <div style={{ width: "98vw", padding: "50px", flexWrap: 'wrap' }}>
        <Typography variant="h2">
          Hi Foodies, What's Your pick
        </Typography>
        <div style={{ display: "flex" }}>
          {pickOption.map((obj, index) => (
            <PickOption key={index} data={obj} />
          ))}
        </div>
      </div>
    </div>

  )
}

export default Home