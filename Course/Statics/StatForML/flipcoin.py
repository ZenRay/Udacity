from __future__ import division
class FlipPredictor(object):
    def __init__(self,coins):
        self.coins=coins
        n=len(coins)
        self.probs=[1/n]*n
    def pheads(self):
        return sum(pcoin*p for pcoin,p in zip(self.coins,self.probs))    

    def update(self,result):
        pheads=self.pheads()
        if result=='H':
            self.probs=[pcoin*p/pheads for pcoin,p in zip(self.coins,self.probs)]
        else:
            self.probs=[(1-pcoin)*p/(1-pheads) for pcoin,p in zip(self.coins,self.probs)]