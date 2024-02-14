import * as React from 'react';
import { useTheme } from '@mui/material/styles';
import Box from '@mui/material/Box';
import MobileStepper from '@mui/material/MobileStepper';
import Paper from '@mui/material/Paper';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';
import KeyboardArrowLeft from '@mui/icons-material/KeyboardArrowLeft';
import KeyboardArrowRight from '@mui/icons-material/KeyboardArrowRight';
import SwipeableViews from 'react-swipeable-views';
import { autoPlay } from 'react-swipeable-views-utils';

const AutoPlaySwipeableViews = autoPlay(SwipeableViews);

const images = [
    "https://plus.unsplash.com/premium_photo-1669150852127-2435412047f2?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8cmVzdG9yYW50fGVufDB8MHwwfHx8MA%3D%3D",
    "https://plus.unsplash.com/premium_photo-1664702602982-7eab3da92601?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OXx8cmVzdG9yYW50fGVufDB8MHwwfHx8MA%3D%3D",
    "https://images.unsplash.com/photo-1587899897387-091ebd01a6b2?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTR8fHJlc3RvcmFudHxlbnwwfDB8MHx8fDA%3D"
];

function ScrollingBanner() {
    const theme = useTheme();
    const [activeStep, setActiveStep] = React.useState(0);

    const handleStepChange = (step) => {
        setActiveStep(step);
    };

    return (
        <AutoPlaySwipeableViews
            axis={theme.direction === 'rtl' ? 'x-reverse' : 'x'}
            index={activeStep}
            onChangeIndex={handleStepChange}
            enableMouseEvents
            style={{ height: '350px', width: '100%', overflowY: 'hidden', top: '0' }}
        >
            {images.map((step, index) => (
                <div key={index} style={{ height: '350px', width: '100%', overflowY: 'hidden' }}>
                    <Box
                        component="img"
                        sx={{
                            height: '100%',
                            width: '100%',
                            objectFit: 'cover'
                        }}
                        src={step}
                        alt="Image Not Found"
                    />
                </div>
            ))}
        </AutoPlaySwipeableViews>
    );
}

export default ScrollingBanner;