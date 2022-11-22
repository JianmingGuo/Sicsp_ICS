# Sicsp_ICS

In this project, we first improve the [GrassMarlin](https://github.com/nsacyber/GRASSMARLIN) to 
accommodate some updates and make it more suitable for industrial control network. 

## Semi-passive Information Acquisition
The most important part is information acquisition. However, considering the particularity of the industrail control network, it's impossible to scan the 
target network like other networks. Thus, we proposed seme-passive information acquisition which integrates active scanning results(nessus etc) and real-time
network topology analysis results.

### GM3-compile

real-time network topology analysis module. The improvements is based on the [GrassMarlin](https://github.com/nsacyber/GRASSMARLIN). The specific improvements refers to storing network information
with an asses list and being well compatible with mysql. This project is the compiled version and can be launched by ```Grass_Launcher```

### Grass_Launcher

The project integrates database operation and the lancher of Grass

## AG/BAG Generation

The object of this project is the network situational awareness of industrial control network. The goal is implemented by Attack Graph(AG) and 
Bayesian Attack Graph(BAG). After obtaining the necessaty information, we first generate the attack graph based on the [mulval](https://people.cs.ksu.edu/~xou/argus/software/mulval/readme.html)
Further, we generate BAG based on the AG. The code is in the ```BAG```.

## Accessory module

### Simulation

Considering the difficult access to industrial control network message, we also developed a simulation module. The code is in ```Simulation```. With the help
of the wireshark, we can easily obtain the message.

### database

A required step is to obtain vulnerability information with the help of NVD/CNVD. So we also upload the code to obtain and analyse NVD/CNVD vulnerability information.

